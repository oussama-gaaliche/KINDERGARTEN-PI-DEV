package tn.esprit.spring.Services;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.React;
import tn.esprit.spring.entity.Reaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.ReactionRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ReactionServiceImpl implements IReactionService {
	@Autowired
	private ReactionRepository reactionRepository;
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private PostRepository postrepository;
	private static final Logger L =(Logger) LogManager.getLogger(ReactionServiceImpl.class);

	public String addReaction(Reaction r) {
		


		List<Reaction> rct = new ArrayList<Reaction>();
		rct = reactionRepository.findAll();

		for (Reaction rp : rct) {
			if (r.getPost().getId() == rp.getPost().getId() && (r.getUser().getId().equals(rp.getUser().getId()))
				)
			// throw new RuntimeException("You can't cancel these !");
			{

				return "user a déja aimé cette pub";
			}

			else {
				
				
				User userManagedEntity = userrepository.findById((long) 1).get();

				Post post = new Post();
				post.setUser(userManagedEntity);
				post.setDate(ZonedDateTime.now());
				
				reactionRepository.save(r);

			}

		}
		return "like enregistré";
	}
	public List<Reaction> retrieveAllLike() {
		List<Reaction> likes = (List<Reaction>) reactionRepository.findAll();
		for (Reaction like : likes) {
			L.info("user +++ : " + like);
		}
		return likes;

}
	
	public String addReaction(Long idUser,Long idPost,Reaction react){
		Reaction rp= new Reaction();
		rp=reactionRepository.reactionExist(idUser, idPost);
		if (rp==null)
		{
		reactionRepository.save(react);
		return "save with succes";
		}
		else if(rp.getReact()!=react.getReact()){
			rp.setReact(react.getReact());
			reactionRepository.save(rp);
		}
		return "update with succes";
	}
}
