package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlanningRepository extends JpaRepository<Planning, Integer> {
	@Query("SELECT DISTINCT p FROM Planning p where p. date_debut=:date")
	
	   public Planning GetPlByDate(@Param("date") Date date);
	@Query("SELECT p.id_planning FROM Planning p where p. date_debut<=:date and p.date_fin>=:date")
	public int GetIDPlan(@Param("date") Date date);
	@Query("SELECT p.id_planning FROM Planning p where p.date_debut<=:date ")
	public int GetIDPlanavant(@Param("date") Date date);


}
