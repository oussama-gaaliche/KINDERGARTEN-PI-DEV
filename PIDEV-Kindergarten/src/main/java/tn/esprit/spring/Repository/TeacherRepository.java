package tn.esprit.spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Teacher;




public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	@Query("Select t from Teacher t where t.id=:id")
	public Teacher getTeacherById(@Param("id") long id);
	
	@Query("Select t from Teacher t where t.user.id=:id")
	public Teacher getTeacherByIdUser(@Param("id") long id);









	

	
	
}
