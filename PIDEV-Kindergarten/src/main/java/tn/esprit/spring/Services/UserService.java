
package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.esprit.spring.Configuration.MyUserDetail;
import tn.esprit.spring.Controller.HomeController;
import tn.esprit.spring.Repository.ClasseRepository;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Niveau;
import tn.esprit.spring.entity.User;

@Service

public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	JardinRepository jardinRepository;
	@Autowired
	EnfantRepository enfantRepository;
	public String userconnect(){
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username="";
	if (principal instanceof UserDetails) {
	   username = ((UserDetails) principal).getUsername();
	} else {
	  username = principal.toString();
	}
	return username;
	}
	public List<User> getAllUsers()
	{	List<User> to =new ArrayList<>();
	userRepository.findAll().forEach(to ::add);
		return to;
	}
	public List<Jardin> getAllJardin()
	{	List<Jardin> ljar =new ArrayList<>();
	jardinRepository.findAll().forEach(ljar ::add);
		return ljar;
	}
	public List<Enfant> getAllEnfant()
	{	List<Enfant> lenfant =new ArrayList<>();
	enfantRepository.findAll().forEach(lenfant ::add);
		return lenfant;
	}
	public List<Classe> getAllClasse()
	{	List<Classe> lclasse =new ArrayList<>();
	classeRepository.findAll().forEach(lclasse ::add);
		return lclasse;
	}
	public void modifyUser(String username,User user)
	{
		User modifieduser =getAllUsers().stream().filter(u->u.getUsername().equals(username)).findFirst().get();
		modifieduser = user;
		userRepository.save(modifieduser);		
	}
	public User  findUserByname(String userName)
	{
		User a = new User();
		a = userRepository.findByUsername(userName).get();
		return a;
	}
	
	public void addClasse(Classe classe,String username){
		User user =getAllUsers().stream().filter(u->u.getUsername().equals(username)).findFirst().get();
		Jardin jardins=getAllJardin().stream().filter(j->j.getUser().getUsername().equals(username)).findFirst().get();
		if (user.getRoles().equals("RESPONSABLE")){
			
				if(classe.getJardin()==jardins.getId()){
					
			classeRepository.save(classe);
				}
				
			}
			
		}
		
		public String affecterEnfant(String username,Long id,String nom,String a){
			Classe classe =getAllClasse().stream().filter(u->u.getNom().equals(nom)).findFirst().get();
			Jardin ljardin =getAllJardin().stream().filter(u->u.getUser().getUsername().equals(username)).findFirst().get();
			Enfant enfant =getAllEnfant().stream().filter(u->u.getId().equals(id)).findFirst().get();
			if(ljardin.equals(enfant.getJardin())){
				if(enfantRepository.findsizeofclasse(classe)<classe.getSize()&&enfant.getNiveau().equals(classe.getNiveau())){
					enfant.setClasse(classe);
					enfantRepository.save(enfant);
				}
				}
				if(!(enfantRepository.findsizeofclasse(classe)<classe.getSize())){
					a="Classe saturé";
				}
				else if(!(enfant.getNiveau().equals(classe.getNiveau()))){
					a="niveau de 'enfant est faux";
				}
				else if(!(ljardin.equals(enfant.getJardin()))){
					a="tu n'a pas le droit d'affecter cette enfant";
				}
					else
						a="affecter enfant succes";
				
				
			
		return a;	
		}
		
		public Niveau randomLetter() {
		    int pick = new Random().nextInt(Niveau.values().length);
		    return Niveau.values()[pick];
		}
		
		public String getAlphaNumericString(int n) 
	    { 
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	        for (int i = 0; i < n; i++) { 
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	        return sb.toString(); 
	    }
		
		public List<User> rechercheuser(String username){
			 return userRepository.rechercheuser(username);
		}
	}


