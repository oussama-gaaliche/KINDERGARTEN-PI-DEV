<<<<<<< HEAD
package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
	<Optional> Rating findById(int note);
	
	@Query("SELECT count(*) FROM Rating r where (r.publicity.id =:idPublicity)")
    public int nbreviews(@Param ("idPublicity") int idPublicity);
	
	@Query(nativeQuery = true, value ="select `id`, `date_rating`, `review`, `publicity_id`, `user_id`, `note` from rating where id order by date_rating desc limit 3")
	public List<Rating> listLastReviews(@Param("id") int id);
	
	
	@Query("select r from Rating r where r.publicity.id=:id order by r.dateRating desc")
	public List<Rating> listReviews(@Param("id") int id);

}
=======
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
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
