package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.PubLikeService;
import tn.esprit.spring.entity.LikePub;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;



@RestController
public class PubLikeController {
	@Autowired
	PubLikeService pubLikeService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicityRepository publicityRepository;
	@PostMapping("/add-pub")
	@ResponseBody
	public String addLike(@RequestBody LikePub l) {
	return pubLikeService.addLike(l);
	//return rating;
	 }
	
	
	@GetMapping(value ="/retrieve-all-likes")
	@ResponseBody
	public List<LikePub> getLikes() {
	
	return pubLikeService.retrieveAllLike();
    
} 
	@GetMapping("/editLike/{id}&{etat}")
	public String updateLike(@PathVariable("id") int id,@PathVariable("etat") boolean etat){
			return pubLikeService.updateLike(id, etat);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{idad}&{etat}")
public String addlike(@PathVariable int  idad,@PathVariable boolean  etat){
		
		
		User us=userRepository.findUserByUsername(HomeController.connectedUser);
		
		Publicity pub = publicityRepository.findById(idad).get();
		
		LikePub lp=new LikePub();
		lp.setUser(us);
		lp.setPublicity(pub);
		//v.setDateCreation(new Date());
		lp.setEtat(etat);
		if(etat==true){
		return	pubLikeService.addLike(us.getId(), idad, lp);
		}
		else
			return pubLikeService.addDislike(us.getId(), idad, lp);
	
	}

	
	@DeleteMapping("/remove-like/{idpub}")
	public void removeLike(@PathVariable("idpub") int idpub) 
	{
		User us=userRepository.findUserByUsername(HomeController.connectedUser);
		
		
		pubLikeService.deleteLike(us.getId(),idpub);
	}

}



