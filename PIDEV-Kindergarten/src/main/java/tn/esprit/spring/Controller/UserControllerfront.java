package tn.esprit.spring.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.Configuration.ActiveUserStore;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.FollowRepository;
import tn.esprit.spring.Repository.FriendRepository;
import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.FollowService;
import tn.esprit.spring.Services.FriendService;
import tn.esprit.spring.Services.MessageService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Follow;
import tn.esprit.spring.entity.Friend;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.MessageBrocker;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;

@Scope(value = "session")
@Controller(value ="userControllerfront")
@ELBeanName(value = "userControllerfront")
@Join(path = "/", to = "/AllUser.jsf")
//@RestController
//@RequestMapping("/secure/rest")
@EnableScheduling
public class UserControllerfront {
	@Autowired
	FollowRepository followRepository;
	@Autowired
	FollowService followservice;
	@Autowired
	FriendService friendservice;
	@Autowired
	FriendRepository friendRepository;
	@Autowired
    ActiveUserStore activeUserStore;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JardinRepository jardinRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
  private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	MessageService messageService;
	@Autowired
	FriendService friendService;
	List<User> friends=new ArrayList<>();
	List<Message> messages=new ArrayList<>();
	List<User> otherfriends=new ArrayList<>();
	
	private String username;
	private String username1="oussama";
	public static final String etat="Accepted";
	public static final String etat1="Not Accepted";
	
	private final Boolean etatt=true;
	
	private User userprofil;
	
	private String messcont;
	
	private String pwds;
	private String npwd;
	private String pwdConfirm;
private int champs;


		public int getChamps() {
	return champs;
}
public void setChamps(int champs) {
	this.champs = champs;
}
		public String getPwds() {
		return pwds;
	}
	public void setPwds(String pwd) {
		this.pwds = pwd;
	}
	public String getNpwd() {
		return npwd;
	}
	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
	public String getPwdConfirm() {
		return pwdConfirm;
	}
	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}
	
	
	


public String getMesscont() {
		return messcont;
	}


	public void setMesscont(String messcont) {
		this.messcont = messcont;
	}


public User getUserprofil() {
		return userprofil;
	}


	public void setUserprofil(User userprofil) {
		this.userprofil = userprofil;
	}


public Boolean getEtatt() {
		return etatt;
	}


public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = lisAmiprefrerer();
	}
	

public List<User> getOtherfriends() {
		return otherfriends;
	}

	public void setOtherfriends(List<User> otherfriends) {
		this.otherfriends = listFNP();
	}
public void remplirusername(User usern){
	username1=usern.getUsername();
	
}
public List<User> lisAmiprefrerer(){
		
		List<User> li= messageService.listactif();
		
		
		return li;
	}
public List<Message> messagesWithOther()
{	System.out.println(HomeController.connectedUser);
System.out.println(username1);
messages= messageService.ourMessages(HomeController.connectedUser,username1);
return messages;
}

public List<User> listFNP(){
	otherfriends=friendService.friendNonPreferer(HomeController.connectedUser);
	
	
		
	return otherfriends;
}

public List<User> RechercheUser(){
	return userService.rechercheuser(username);
}

public User userconnecter(){
	return userRepository.userconnect(HomeController.connectedUser);
}
public User userpointer(String uu){
	return userRepository.userconnect(uu);
}
public List<User> mySendedDemandes()
{
	List<Follow> follows=new ArrayList<>();
	List<User> users=new ArrayList<>();
	follows=followservice.myReivedDemandes(HomeController.connectedUser);
	for(Follow f : follows){
		
		users.add(userRepository.userfollow(f.getId_Sender()));
	}
	return users;
}

public void AcceptdemandeStatus( Long  id)
{
	
	Follow follow=new Follow();
	Follow follow1=new Follow();
	follow1=followRepository.cherchefollow(id, HomeController.connectedUser).stream().findFirst().get();
	follow=followRepository.findById(follow1.getId()).get();
	
	follow.setEtat("Accepted");
	followservice.changeStatus(follow, follow1.getId());
	int idd=follow1.getId();
	follow = followservice.allFollows().stream().filter(d->d.getId()==idd).findFirst().get();
	
	boolean s=false;
	
		
	for(Friend f :friendService.allFriend()){
		if((f.getUser1()==follow.getId_Sender()&& f.getUser2()==follow.getUserReciver().getId())||(f.getUser2()==follow.getId_Sender()&& f.getUser1()==follow.getUserReciver().getId()))
			s=true;
		
	}
	
		if(follow.getUserReciver().getUsername().equals(HomeController.connectedUser)&&s==false)
		friendService.addFriend(new Friend(follow.getId_Sender(),follow.getUserReciver().getId(),false,false,false,null));
		
}

public String refusedemandeStatus( Long  id)
{
	
	
	Follow follow=new Follow();
	Follow follow1=new Follow();
	follow1=followRepository.cherchefollow(id, HomeController.connectedUser).stream().findFirst().get();;
	follow=followRepository.findById(follow1.getId()).get();
	follow.setEtat("not Accepted");
	followservice.changeStatus(follow, follow1.getId());
	int idd=follow1.getId();
	follow = followservice.allFollows().stream().filter(d->d.getId()==idd).findFirst().get();
	boolean s=false;
	if(follow.getEtat().equals("not Accepted "))	{
		
	for(Friend f :friendService.allFriend()){
		if((f.getUser1()==follow.getId_Sender()&& f.getUser2()==follow.getUserReciver().getId())||(f.getUser2()==follow.getId_Sender()&& f.getUser1()==follow.getUserReciver().getId()))
			s=true;
		
	}
	if(s==true)
		return "";
	else {
		if(follow.getUserReciver().getUsername().equals(HomeController.connectedUser))
		friendService.addFriend(new Friend(follow.getId_Sender(),follow.getUserReciver().getId(),false,false,false,null));
		else
			return "";
	}
	}
	else
		followservice.DeleteFollow(follow);	
	return "";
}

public List<User> AllUser(){
	return userService.getAllUsers();
}

public int friendex(long id){
	
List<Friend> friends=new ArrayList<>();
friends=friendservice.allFriend();
for(Friend f : friends){
	if((f.getUser1()==id && f.getUser2()==userconnecter().getId())||(f.getUser2()==id && f.getUser1()==userconnecter().getId()))
		return 1;
	
	
}
return 0;
	
}
public int followex(long id){
	List<Follow> follows=new ArrayList<>();
	follows=followservice.allFollows();
	for(Follow f : follows){
		if((f.getId_Sender()==id && f.getUserReciver().getId()==userconnecter().getId()))
			return 1;
	}
	return 0;
}
public int followreciver(long id){
	List<Follow> follows=new ArrayList<>();
	follows=followservice.allFollows();
	for(Follow f : follows){
	if(f.getId_Sender()==userconnecter().getId() && f.getUserReciver().getId()==id)
		return 1;
	}
	return 0;
}
public String deletFollow(long id){
	followservice.DeleteFollow1(id);
	return "/AllUser.xhtml?faces-redirect=true";
}
public String deletFollow5(long id){
	followservice.DeleteFollow1(id);
	return "/profil.xhtml?faces-redirect=true";
}
public void deletFollow1(long id){
	followservice.DeleteFollow2(id);
}
String navigateTo = "null";
public String afficheprofil(User userp){
	userprofil = userp;
	System.out.println(userprofil.getNom());
	return "/profil.xhtml?faces-redirect=true";
}
public String affichefriend(){
	return "/ProfileFriend.xhtml?faces-redirect=true";
}
public List<User> friendp(){
	
return friendservice.myFriends(userprofil.getUsername());
}
public int friendblock(long id){
	
	List<Friend> friends=new ArrayList<>();
	friends=friendservice.allFriend();
	for(Friend f : friends){
		if(f.isStatus()==true && (f.getUser1()==id && f.getUser2()==userconnecter().getId())||(f.getUser2()==id && f.getUser1()==userconnecter().getId()))
			return 1;
		
}
	return 0;
}
public int countFriend(){
	return friendRepository.countfriend(userprofil.getId());
}
public void blockFriend(Long id){
	friendService.BlockFriend(id, HomeController.connectedUser);
	
	
}
public String blockSignFriend(Long id){
	return friendService.BlocksigFriend(id, HomeController.connectedUser);
	
	
}
public String deletfriend(Long id){
	friendservice.deletfriend(id, userconnecter().getId());
	return "/profil.xhtml?faces-redirect=true";
}
public void sendMessage()
{
	MessageBrocker message=new MessageBrocker();
	message.setUserReciver(userpointer(username1).getUsername());
	message.setMessageContent(messcont);
	message.setSendDate(new Date());
	message.setStatus(false);
	message.setUserSender(HomeController.connectedUser);
	if(messageService.nbmessage(message.getUserSender(),message.getUserReciver())<5)
	messageService.sendMessage(message);
	
}
public String sendDemand(String username)
{
	User reciever = new User();
	reciever=userRepository.findByUsername(username).get();
	User sender = new User();
	sender=userRepository.findByUsername(HomeController.connectedUser).get();
	
	List<Follow> follows=new ArrayList<>();
	follows=followRepository.findFollowByUserReciver(reciever);
	for (Follow f : follows) {
		if( f.getId_Sender()==sender.getId()){
			return "/AllUser.xhtml?faces-redirect=true";
			
		}
		
	}
	
	System.out.println(HomeController.connectedUser);
	followservice.SendDemande(username, HomeController.connectedUser);
	 return "/AllUser.xhtml?faces-redirect=true";
	
}
public String sendDemand1(String username)
{
	User reciever = new User();
	reciever=userRepository.findByUsername(username).get();
	User sender = new User();
	sender=userRepository.findByUsername(HomeController.connectedUser).get();
	
	List<Follow> follows=new ArrayList<>();
	follows=followRepository.findFollowByUserReciver(reciever);
	for (Follow f : follows) {
		if( f.getId_Sender()==sender.getId()){
			return "/profil.xhtml?faces-redirect=true";
			
		}
		
	}
	
	System.out.println(HomeController.connectedUser);
	followservice.SendDemande(username, HomeController.connectedUser);
	 return "/profil.xhtml?faces-redirect=true";
	
}
public String gottoAlluser(){
	return "/AllUser.xhtml?faces-redirect=true";
}

public String gottoforgotpassword(){
	return "/forgetpassword.xhtml?faces-redirect=true";
}

public String changepwd(){
	User user1= new User();
	user1=userconnecter();
	BCryptPasswordEncoder encod = new BCryptPasswordEncoder();
	String encryptpwd= passwordEncoder.encode(pwds);
	String encryptpw1=passwordEncoder.encode(npwd);
	if(encod.matches(pwds, user1.getPassword()))
		if(npwd.equals(pwdConfirm))
		{
			
			user1.setPassword(encryptpw1);
			user1.setPasswordConfirm(encryptpw1);
			userRepository.save(user1);
		}
		return "/forgetpassword.xhtml?faces-redirect=true";
	
}

public void ValidateuserwithResponsable( long id) {
	 Model model;
	String a;
    User user = userRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
   // Enfant enfants=new Enfant();
   // Enfant enfants= new ArrayList();
    List<Enfant> enfants=enfantRepository.findByUser(user);
    Boolean status=false;
    List<String> moulabash=new ArrayList();
    for(Enfant e : enfants){
    	moulabash.add(e.getJardin().getUser().getUsername());
    	if (e.getClasse()!=null)
    	{status=true;}
    	
    }
    System.out.println(enfants);
    if((user.getRoles().equals("PARENT")&&enfants.size()>0 && status==true)||user.getRoles().equals("ENSEIGNANT")){
    	for(String e : moulabash){
    		if(e.equals(HomeController.connectedUser))
    			break;
    		else
    			champs=1;
    		
    	}
//    model.addAttribute("user", user);
    user.setActive(true);
    user.setStatus("yes");
    userRepository.save(user);
  
    }
    if(enfants.size()<=0 )
	{champs=2;}
    
    else if(status==false)
	{champs=3;}
else  {champs=4;}
    
    
    
}
}
