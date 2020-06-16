package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.RatingRepository;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;

@Service
public class RatingService implements IRatingService {
	@Autowired
	private RatingRepository RatingRepository;
	private static final Logger L = (Logger) LogManager.getLogger(PublicityServiceImpl.class);

	public List<Rating> retrieveAllRating() {
		List<Rating> ratings = (List<Rating>) RatingRepository.findAll();
		for (Rating rating : ratings) {
			L.info("user +++ : " + rating);
		}
		return ratings;

	}

	@Override
	public String addRating(Rating r) {

		List<Rating> rating = new ArrayList<Rating>();
		rating = RatingRepository.findAll();

		for (Rating rate : rating) {
			if (r.getPublicity().getId() == rate.getPublicity().getId()
					&& (r.getUser().getId().equals(rate.getUser().getId())))

			{
				// updateRating(rate.getId());
				Rating ratingEdit = new Rating();

				ratingEdit = RatingRepository.findById(rate.getId());

				// rating.setNote(note);

				ratingEdit.setNote(r.getNote());
				ratingEdit.setReview(r.getReview());
				ratingEdit.setDateRating(new Date());
				RatingRepository.save(ratingEdit);
				return "user a déja évalué cette pub";

			}

			// r.setDateRating(new Date());
			// RatingRepository.save(r);

		}

		r.setDateRating(new Date());
		RatingRepository.save(r);
		return "note enregistré";
	}

	@Override
	public String updateRating(int id) {

		Rating rating = new Rating();

		rating = RatingRepository.findById(id);

		// rating.setNote(note);

		// rating.setNote(5);
		rating.setDateRating(new Date());
		RatingRepository.save(rating);

		return "note enregistré";
	}

	@Override
	public void deleteRating(int i) {
		RatingRepository.deleteById(i);

	}

	@Override
	public int nbReview(int id) {

		return RatingRepository.nbreviews(id);
	}

	@Override
	public List<Rating> retrieveAllReviews(int id) {

		return RatingRepository.listReviews(id);

	}
	
	@Override
	public List<Rating> listLastReviews(int id) {

		return RatingRepository.listLastReviews(id);

	}

}
