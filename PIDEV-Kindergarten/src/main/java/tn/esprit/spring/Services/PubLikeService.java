package tn.esprit.spring.Services;

import java.util.ArrayList;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.PubLikeRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.LikePub;
import tn.esprit.spring.entity.Publicity;



@Service 
public class PubLikeService implements IPubLikeService  {
	@Autowired
    private PubLikeRepository PubLikeRepository;
	
	private static final Logger L =(Logger) LogManager.getLogger(PubLikeService.class);
	
	public List<LikePub> retrieveAllLike() {
		List<LikePub> likes = (List<LikePub>) PubLikeRepository.findAll();
		for (LikePub like : likes) {
			L.info("user +++ : " + like);
		}
		return likes;

}
	
	@Override
	public String addLike(LikePub l) {
		
		List<LikePub> like =new ArrayList<LikePub>();
		like=PubLikeRepository.findAll();

		
		for( LikePub lp : like)
		{
			if (l.getPublicity().getId()==lp.getPublicity().getId() && (l.getUser().getId().equals(lp.getUser().getId() ) ) && 
					l.isEtat()==lp.isEtat())
				 // throw new RuntimeException("You can't cancel these !");
			{
				
			return "user a déja aimé cette pub";
}
	
			else 
		    {
			PubLikeRepository.save(l);
			
				}
}
		return "like enregistré";
	}
	
	public String addLike(Long iduser,int idad,LikePub likepub){
		LikePub lp= new LikePub();
		lp=PubLikeRepository.likeexist(iduser, idad);
		if (lp==null)
		{
		PubLikeRepository.save(likepub);
		return "save with succes";
		}
		else if(lp.isEtat()==false){
			lp.setEtat(true);
			PubLikeRepository.save(lp);
		}
		return "update with succes";
	}
	public String addDislike(Long iduser,int idad,LikePub likepub){
		LikePub lp= new LikePub();
		lp=PubLikeRepository.likeexist(iduser, idad);
		if (lp==null){
		PubLikeRepository.save(likepub);
		return "save with succes";
		}
		else if(lp.isEtat()==true){
			lp.setEtat(false);
			PubLikeRepository.save(lp);
		}
		return "update with succes";
	}
	@Override
	public String updateLike(int id,boolean etat) {
		
		LikePub like =new LikePub();
		like=PubLikeRepository.findById(id);

		like.setEtat(etat);
		
		/*if (etat==like.isEtat() && etat==true)
		
			
			{
			return "tu as déjas aimé cette publicité ";
				
				}
				
			else if (etat==like.isEtat() && etat==false)
		    {  
				return "tu as déjas aimé cette publicité ";
             }*/
		
		PubLikeRepository.save(like);
        return "react updated";
	}
	
	public int nbLike(int id)
	{
		return PubLikeRepository.nbLike(id);
	}
	
	public int nbDisLike(int id)
	{
		return PubLikeRepository.nbDisLike(id);
	}
	
	@Override
	public void deletePubLike(int i) {
		PubLikeRepository.deleteById(i);
		
	}
	@Override
	public String deleteLike(Long iduser,int idad){
		LikePub lp= new LikePub();
		lp=PubLikeRepository.likeexist(iduser, idad);
		if (lp==null)
		{
		
		return "pub doesn't exist";
		}
		else {
			
			PubLikeRepository.delete(lp);
		}
		return "deletion with succes";
	}
	

}
