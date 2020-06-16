package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.Repository.ratingRestoRepository;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.ratingResto;
import tn.esprit.spring.entity.ratingRestoPk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class RatingRestoServiceImpl implements RatingRestoService {
	@Autowired 
	ratingRestoRepository ratingresto;
	private static final Logger L =(Logger) LogManager.getLogger(RatingRestoServiceImpl.class);
	
	
	public List<ratingResto> retrieveAllRating() {
		List<ratingResto> ratings = (List<ratingResto>) ratingresto.findAll();
		for (ratingResto rating : ratings) {
			L.info("user +++ : " + rating);
		}
		return ratings;

}
	public String addRating(ratingResto r,int idp,long u ){
		List<ratingResto> rating =new ArrayList<ratingResto>();
		rating=ratingresto.findAll();
		for( ratingResto rate : rating)
		{
            if (ratingresto.planrate(idp)==rate.getRatingrestopk().getIdplan() && (ratingresto.userrate(u)==(rate.getRatingrestopk().getIduser())) )
				
			{
				
			return "user a déja évalué cette planning";
			}
            else 
		    {  
			ratingRestoPk ratepk =new ratingRestoPk();
		    ratepk.setIdplan(idp);
		    ratepk.setIduser(u);
		    r.setRatingrestopk(ratepk);
		    
				r.setDateRating(new Date());
				ratingresto.save(r);
				
				
            }}
		return "Evaluation ajouté avec succée";
	}
	
	
/*
	@Override
	public String updateRating(int id, float note) {
		ratingResto rating =new ratingResto();
		rating=ratingresto.f;

		rating.setNote(note);
		
			
			
			 if (rating.getNote()>10  ||rating.getNote()<0 )
			{
				
				return "il faut saisir une note comprise entre 0 et 10 ";
				
				}
				
			else 
		    {   
				rating.setDateRating(new Date());
				ratingresto.save(rating);
				
				
		    }

			 return "note enregistré";
	}*/
	

	@Override
	public void deleteRating(ratingResto r) {
		ratingresto.delete(r);
		
	}

	@Override
	public int nbReview(int id) {
		return ratingresto.nbreviews(id);
		
	}

	@Override
	public List<ratingResto> retrieveAllReviews(int id) {
		return ratingresto.listReviews(id);
	}


	@Override
	public String updateRating(int id, float note) {
		// TODO Auto-generated method stub
		return null;
	}

 public String badrepad(int id){
	
	 if (ratingresto.ratingbadrepas(id)>2){
	  System.out.println( "vous devez modifié le repas");
	  return "vous devez modifié le repas";}
	  return "vous devez modifié le repas";}

}
