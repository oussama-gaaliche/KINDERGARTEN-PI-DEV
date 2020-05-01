package tn.esprit.spring.Repository;



import tn.esprit.spring.entity.Planning;

import tn.esprit.spring.entity.TypePlat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlanningRepository extends JpaRepository<Planning, Integer> {
	@Query("SELECT DISTINCT p FROM Planning p where p. date_debut=:date")
	
	   public List<Planning> GetPlByDate(@Param("date") Date date);
	


}
