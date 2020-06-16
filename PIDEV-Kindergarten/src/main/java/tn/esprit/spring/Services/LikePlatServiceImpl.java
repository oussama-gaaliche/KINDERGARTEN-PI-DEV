package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.Repository.LikePlatRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.entity.LikePlat;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.ratingResto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LikePlatServiceImpl implements LikePlatService {
        @Autowired
        LikePlatRepository likeplatrepo;
        @Autowired
        PlatRepository platrepo;
        private static final Logger L =(Logger) LogManager.getLogger(LikePlatServiceImpl.class);
    	
	@Override
	public String addLike(LikePlat l) {
		List<LikePlat> like =new ArrayList<LikePlat>();
		like=likeplatrepo.findAll();

		
		for( LikePlat lp : like)
		{
			if (l.getPlat().getId_plat()==lp.getPlat().getId_plat() && (l.getUser().getId()==(lp.getUser().getId() ) ) && 
					l.isEtat()==lp.isEtat())
				 // throw new RuntimeException("You can't cancel these !");
			{
				
			return "user a déja aimé cette pub";
}
	
			else 
		    {
				likeplatrepo.save(l);
			
				}
}
		return "like enregistré";
	}
	public String addLike(long iduser,int idad,LikePlat likep){
		LikePlat lp= new LikePlat();
		lp=likeplatrepo.likeexist(iduser, idad);
		if (lp==null)
		{
			likeplatrepo.save(likep);
		return "save with succes";
		}
		else if(lp.isEtat()==false){
			lp.setEtat(true);
			likeplatrepo.save(lp);
		}
		return "update with succes";
	}
	public String addDislike(long iduser,int idad,LikePlat likepub){
		LikePlat lp= new LikePlat();
		lp=likeplatrepo.likeexist(iduser, idad);
		if (lp==null){
			likeplatrepo.save(likepub);
		return "save with succes";
		}
		else if(lp.isEtat()==true){
			lp.setEtat(false);
			likeplatrepo.save(lp);
		}
		return "update with succes";
	}

	@Override
	public List<LikePlat> retrieveAllLike() {
		List<LikePlat> likes = (List<LikePlat>) likeplatrepo.findAll();
		for (LikePlat like : likes) {
			L.info("user +++ : " + like);
		}
		return likes;
	}

	@Override
	public String updateLike(int id, boolean etat) {
		LikePlat like =new LikePlat();
		like=likeplatrepo.findById(id);

		like.setEtat(etat);
		
		/*if (etat==like.isEtat() && etat==true)
		
			
			{
			return "tu as déjas aimé cette publicité ";
				
				}
				
			else if (etat==like.isEtat() && etat==false)
		    {  
				return "tu as déjas aimé cette publicité ";
             }*/
		
		likeplatrepo.save(like);
        return "react updated";
	}

	@Override
	public int nbLike(int id) {
		return likeplatrepo.nbLike(id);
	}
	public int nbDisLike(int id)
	{
		return likeplatrepo.nbDisLike(id);
	}
	
	public String updateplat(int id){
		//Plat p=new Plat();
		int i=likeplatrepo.nbDisLike(id);

		List<Plat> pl =new ArrayList<Plat>();
		pl=platrepo.findAll();

		for( Plat pp : pl)
		{if (pp.getId_plat()==id)

		if (i>=2){
			platrepo.delete(pp);
		return "plat ok ";}
		else
			return "non";}return"lol";}
	
	public int meilleurPlat(){
		return likeplatrepo.meilleurPlat();
	}
	/*public Map<Integer,Plat> Platparjm(){
		return likeplatrepo.Platparjm();
	}*/
 public List<?> Platjm(){
		
	return likeplatrepo.Platparjm();}
		
	}
	



