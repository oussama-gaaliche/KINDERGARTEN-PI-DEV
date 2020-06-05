package tn.esprit.spring.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Part;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Configuration.ActiveUserStore;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.FriendService;
import tn.esprit.spring.Services.MessageService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.User;
@Scope(value = "session")
@Controller(value ="userControlleradd")
@ELBeanName(value = "userControlleradd")
@Join(path = "/Acceuil.jsf", to = "/Acceuil.jsf")
public class UserControlerAdd {
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
	public String im;
	private User useradd;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String passwordConfirm;
	private String username;
	private String status;
	private Long numtel;
	private String Roles;
	private Part  myImage;


	public Part getMyImage() {
		return myImage;
	}
	public void setMyImage(Part myImage) {
		this.myImage = myImage;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getNumtel() {
		return numtel;
	}
	public void setNumtel(Long numtel) {
		this.numtel = numtel;
	}
	public User getUseradd() {
		return useradd;
	}
	public void setUseradd(User useradd) {
		this.useradd = useradd;
	}
	public String addUser(){
			User usera=new User();
			usera.setNom(nom);
			usera.setPrenom(prenom);
			usera.setEmail(email);
			usera.setPassword(password);
			usera.setPasswordConfirm(passwordConfirm);
			
			usera.setUsername(username);
			usera.setNumtel(numtel);
			usera.setRoles(Roles);
			System.out.println("ammar§§§§§§§§§§"+usera.getNom());
			if(usera.getPassword().equals(usera.getPasswordConfirm())){
			String pwd=usera.getPassword();
			String encryptpwd= passwordEncoder.encode(pwd);
			usera.setPassword(encryptpwd);
			usera.setScore(0);
			usera.setRoles("ADMIN");
			usera.setStatus("0");
			
			usera.setDateInscription(new Date());
			usera.setActive(false);
			usera.setImage("lol");
			System.out.println(im);
			userRepository.save(usera);
			
			return "";
			}
			return "";
		}
	
	public void addImage() throws IOException {
    	System.out.println("oussama!!!!!!!!!!!!!!!");
    	myImage.write("C:\\Users\\Oussama\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\files\\userImage\\"+myImage.getSubmittedFileName());		 		 
		 File oldFile=new File("C:\\Users\\Oussama\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\files\\userImage\\"+myImage.getSubmittedFileName());
		 String AddedName=userService.getAlphaNumericString(7)+myImage.getSubmittedFileName();
		 File newfile =new File("C:\\Users\\Oussama\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\files\\userImage\\"+AddedName);
		 oldFile.renameTo(newfile);		 
//		 User userWithImage= new User();
//		 userWithImage  = connectedUser;
//		 userWithImage.setPhoto(AddedName);
//		 userService.addUser(userWithImage);
    	im=AddedName;
  
	}
	

}
