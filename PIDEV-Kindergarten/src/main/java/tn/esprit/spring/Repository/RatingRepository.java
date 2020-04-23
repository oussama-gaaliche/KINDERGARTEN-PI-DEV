package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
	<Optional> Rating findById(int note);
	

}
