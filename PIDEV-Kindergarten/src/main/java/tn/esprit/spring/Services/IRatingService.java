package tn.esprit.spring.Services;




import tn.esprit.spring.entity.Rating;

public interface IRatingService {

	public String addRating(Rating r);
	public String updateRating(int id,float note);
	public void deleteRating(int i);
	
	

}
