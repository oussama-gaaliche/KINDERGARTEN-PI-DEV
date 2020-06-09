package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Enfant;




public interface CreneauRepository extends JpaRepository<Creneau, Long> {
	
	
	/**
	 * Find Timeslot list of given teacher
	 */
	@Query("select DISTINCT c from Creneau c where c.teacher.id=?1")
	Iterable<Creneau> getAllCreneaux(long idTeacher);
	@Query("Select c from Creneau c where c.id=:id")
	public Creneau getCreneauById(@Param("id") long id);
	
}
