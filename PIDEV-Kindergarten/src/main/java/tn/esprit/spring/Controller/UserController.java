package tn.esprit.spring.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Configuration.ActiveUserStore;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.FriendService;
import tn.esprit.spring.Services.MessageService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.MessageBrocker;
import tn.esprit.spring.entity.Oppor;
import tn.esprit.spring.entity.User;
@RestController
@RequestMapping("/secure/rest")
@EnableScheduling
public class UserController {
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
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user){
		if(user.getPassword().equals(user.getPasswordConfirm())){
		String pwd=user.getPassword();
		String encryptpwd= passwordEncoder.encode(pwd);
		user.setPassword(encryptpwd);
		user.setActive(false);
		
		userRepository.save(user);
		return " added user succes";
		}
		return"verify mot de passe";
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/edit/{id}")
	public String ValidateuserwithAdmin(@PathVariable("id") long id, Model model) {
		String a;
	    User user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	   Jardin jardins=jardinRepository.findByUser(user);
	   System.out.println(jardins);
	    if((user.getRoles().equals("RESPONSABLE")&&jardins!=null)||user.getRoles().equals("ADMIN")){
	    model.addAttribute("user", user);
	    user.setActive(true);
	    userRepository.save(user);
	    a="update-user";
	    }
	    else a="you cannot validate user that had role as "+ user.getRoles();
	    return a;
	    
	}
	//@PreAuthorize("hasRole('PARENT'")
	@GetMapping("/editparent/{id}")
	public String ValidateuserwithResponsable(@PathVariable("id") long id, Model model) {
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
	    			return "you had not le droit de affcter ce parent";
	    		
	    	}
	    model.addAttribute("user", user);
	    user.setActive(true);
	    userRepository.save(user);
	  
	    }
	    if(enfants.size()<=0 )
    	{a="you havent any enfant";}
	    else if(!user.getRoles().equals("PARENT"))  
	    	a="you cannot validate user that had role as "+ user.getRoles();
	    else if(status==false)
    	{a="you havent any child affeted to a class";}
    else  {a="update-user";}
	    return a;
	    
	    
	}
	@RequestMapping(value = "/profile1")
	@ResponseBody
    public User  currentUserName() {         
         return userService.findUserByname(HomeController.connectedUser);                 
    }
	
	//@RequestMapping(method = RequestMethod.PUT,value="/profile")
	@PutMapping(value="/profile")
	public void editAccount(@RequestBody User user)
	{
		userService.modifyUser(HomeController.connectedUser, user);
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/send")
	public String sendMessage(@RequestBody MessageBrocker message)
	{
		message.setSendDate(new Date());
		message.setStatus(false);
		message.setUserSender(HomeController.connectedUser);
		if(messageService.nbmessage(message.getUserSender(),message.getUserReciver())==5)
			return "attendez que votre ami repondre";
		messageService.sendMessage(message);
		return "message sended with acces";
	}
	@Scheduled(initialDelay=1000L,fixedDelayString= "PT10S")
	public void checkForMessages()
	{
		messageService.sendedMessages().stream().filter(s->((s.isStatus() == false)&&s.getUserReciver().equals(HomeController.connectedUser))).forEach(sended->
		{
			messageService.sendMessageToSpecificUser(sended);
			sended.setStatus(true);
			messageService.sendMessage(sended);
			
		});
}
	@RequestMapping(value="/messages/{username}")
	public List<Message> messagesWithOther(@PathVariable String username)
	{	System.out.println("qsdqsdqsd"+HomeController.connectedUser);
		return messageService.ourMessages(HomeController.connectedUser, username);
	}
	@RequestMapping(value="/deletemessage/{id}")
	public String deletmessage(@PathVariable Long id){
		return messageService.deleteMessage(HomeController.connectedUser, id);
		
	}
	@PostMapping("/addclasse")
	public String addClasse(@RequestBody Classe classe){
		userService.addClasse(classe, HomeController.connectedUser);
		System.out.println(userService.randomLetter());
		return "add classe succes";
		
	}
	@GetMapping("/affectEnfant/{id}&{classe}")
	public String affecterEnfant(@PathVariable("id") long id,@PathVariable("classe") String nom){
		String a="";
		return userService.affecterEnfant(HomeController.connectedUser, id, nom,a);
		
	}
	@GetMapping("/listapref")
	public List<User> lisAmiprefrerer(){
		
		List<User> li= messageService.listactif();
		
		
		return li;
	}
	@GetMapping("/listanonpref")

	public List<User> listFNP(){
		return friendService.friendNonPreferer(HomeController.connectedUser);
	}
	
 
    @GetMapping("/loggedUsers")
    public String getLoggedUsers(Locale locale, Model model) {
        model.addAttribute("users", activeUserStore.getUsers());
        return "users";
    }
	}