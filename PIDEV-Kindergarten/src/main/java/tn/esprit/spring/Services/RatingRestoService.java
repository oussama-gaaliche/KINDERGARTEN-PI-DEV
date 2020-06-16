package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.ratingResto;



public interface RatingRestoService {
	public String addRating(ratingResto r,int id,long iduser);
	public String updateRating(int id,float note);
	public void deleteRating(ratingResto r);
	public int nbReview(int id);
	public List<ratingResto> retrieveAllRating();
	 public String badrepad(int id);
	
	public List<ratingResto> retrieveAllReviews(int id);

}
