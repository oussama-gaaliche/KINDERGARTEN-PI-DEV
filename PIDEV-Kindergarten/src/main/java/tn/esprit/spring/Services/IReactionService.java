package tn.esprit.spring.Services;


import java.util.List;

import tn.esprit.spring.entity.Reaction;

public interface IReactionService {
	public String addReaction(Long idUser,Long idPost, Reaction rp);

	public List<Reaction> retrieveAllLike();

	public String addReaction(Reaction l);

}
