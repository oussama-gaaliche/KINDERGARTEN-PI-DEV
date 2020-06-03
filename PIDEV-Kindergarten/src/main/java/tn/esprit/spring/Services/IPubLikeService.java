package tn.esprit.spring.Services;



import java.util.List;

import tn.esprit.spring.entity.LikePub;


public interface IPubLikeService {
	
	public String addLike(LikePub l);
	public List<LikePub> retrieveAllLike();
	public String updateLike(int id, boolean etat);
	public int nbLike(int id);
	void deletePubLike(int i);
	public String deleteLike(Long iduser,int idad);
}
