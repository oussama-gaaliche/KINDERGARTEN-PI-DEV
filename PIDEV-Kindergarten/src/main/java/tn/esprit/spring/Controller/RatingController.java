package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.RatingService;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;
//commit
@RestController
public class RatingController {
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/add-rating")
	@ResponseBody
	public String addRating(@RequestBody Rating r) {
	return ratingService.addRating(r);
	//return rating;
	 }
	
	@GetMapping(value ="/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() {
	
	return ratingService.retrieveAllRating();
    
} 
	/*@GetMapping("/editNote/{id}&{note}")
public String updateNote(@PathVariable("id") int id,@PathVariable("note") int note){
		return ratingService.updateRating(id, note);
	
}
	*/
	@DeleteMapping("/remove-rating/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int id) {
	ratingService.deleteRating(id);
	 }
	
	
	@GetMapping(value = "retrieve-all-ratingParPub/{id}")
	@ResponseBody
	public List<Rating> getPublicitiesParPub(@PathVariable("id") int id) {

		return ratingService. retrieveAllReviews(id);

	}

}





