<<<<<<< HEAD
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Evaluation;
@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer>{
	@Query(value="Select  e.id_event,(SUM(e.evaluation_value)) as somme from Evaluation e "
			+ "GROUP BY(e.id_event) ORDER BY somme desc limit 1" ,nativeQuery=true)
	
	public  int top_evaluation_event();
	
	
	@Query("SELECT count(*) FROM Evaluation")
    public int countemp();

}
=======
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Evaluation;
@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer>{
	@Query(value="Select  e.id_event,(SUM(e.evaluation_value)) as somme from Evaluation e "
			+ "GROUP BY(e.id_event) ORDER BY somme desc limit 1" ,nativeQuery=true)
	
	public  int top_evaluation_event();
	
	
	@Query("SELECT count(*) FROM Evaluation")
    public int countemp();

}
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
