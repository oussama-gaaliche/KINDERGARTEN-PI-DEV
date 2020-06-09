package tn.esprit.spring.Repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Rv;




public interface RvRepository extends JpaRepository<Rv, Long> {


	@Query(value = "INSERT INTO rv (jour,id_creneau,id_enfant) VALUES (:j, :c, :e)", nativeQuery = true) 
	@Transactional
	public Rv ajouterRv(@Param("j") Date jour, @Param("c") long créneau, @Param("e") long enfant); 
	@Query("select rv from Rv rv where rv.creneau.teacher.id=?1 and rv.jour=?2")
	Iterable <Rv> getRvTeacherJour(long idTeacher, Date jour);
	@Query("Select r from Rv r where r.id=:id")
	public Rv getRvById(@Param("id") long id);
	




	
	
}
