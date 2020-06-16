package tn.esprit.spring.Controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.React;
import tn.esprit.spring.entity.Reaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.Repository.PostRepository;
import tn.esprit.spring.Repository.ReactionRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.IPostService;
import tn.esprit.spring.Services.IReactionService;

@RestController

public class LikeController {
	@Autowired
	IReactionService reactService;
	@Autowired
	private ReactionRepository reactionRepository;
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private PostRepository postrepository;

	@RequestMapping(method = RequestMethod.PUT, value = "/post/{id}/{idUser}")
	public String addreaction(@PathVariable("id") long idPost, @PathVariable("idUser") long idUser, Reaction react) {

		User userManagedEntity = userrepository.findById((long) 1).get();
		Post postefound = postrepository.findById((long) idPost).get();

		Reaction rp = new Reaction();
		rp.setUser(userManagedEntity);
		rp.setPost(postefound);
		rp.setReact(React.LOVE);
		rp.setDate(ZonedDateTime.now());
		// v.setDateCreation(new Date());

		return reactService.addReaction(userManagedEntity.getId(), idPost, rp);

	}
	@GetMapping(value ="/retrieve-all-likes")
	@ResponseBody
	public List<Reaction> getLikes() {
	
	return reactService.retrieveAllLike();
	}
	
	
	@PostMapping("/addlike")
	@ResponseBody
	public String addLike(@RequestBody Reaction l) {
	return reactService.addReaction(l);
	//return rating;
	 }
    
}
