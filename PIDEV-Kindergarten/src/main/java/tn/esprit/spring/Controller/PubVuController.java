package tn.esprit.spring.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.Repository.UserRepository;

import tn.esprit.spring.Services.PubVuService;

import tn.esprit.spring.entity.PubVu;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;

@RestController
public class PubVuController {
	@Autowired
	PubVuService pubVuService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicityRepository publicityRepository;
	@RequestMapping(method=RequestMethod.PUT,value="addview/{iduser}&{idad}")
	public String addvu(@PathVariable Long  iduser,@PathVariable int  idad){
			
			Optional<User> user=userRepository.findById(iduser);
			
			System.out.println(user);
			Publicity pub = publicityRepository.findById(idad).get();
			
			PubVu pv=new PubVu();
			pv.setUser(user.get());
			pv.setPublicity(pub);
			//v.setDateCreation(new Date());
			//lp.setEtat(etat);
			
			return	pubVuService.addVu(iduser, idad,pv);
			
		
				
			
			
		}

}
