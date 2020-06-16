package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	<Optional> Rating findById(int note);
	
	@Query("SELECT count(*) FROM Rating r where (r.publicity.id =:idPublicity)")
    public int nbreviews(@Param ("idPublicity") int idPublicity);
	
	@Query("select r from Rating r where r.publicity.id=:id order by r.dateRating desc")
	public List<Rating> listReviews(@Param("id") int id);
	


}
