package tn.esprit.spring.Repository;



import tn.esprit.spring.entity.Planning;

import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlanningRepository extends JpaRepository<Planning, Integer> {
	


}
