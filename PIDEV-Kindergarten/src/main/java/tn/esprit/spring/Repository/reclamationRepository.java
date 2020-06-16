package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.TypeReclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;

public interface reclamationRepository extends JpaRepository<reclamation, Long> {
	@Query("Select r from reclamation r where r.id=:id")
	public reclamation getReclamationById(@Param("id") long id);

	@Query("SELECT r " 
	       + "FROM reclamation r " 
		   + "WHERE r.typeReclamation = :typeReclamation " + "ORDER BY r.posted DESC")
	List<reclamation> findByTypeReclamationOrderByPostedDesc(@Param("typeReclamation") TypeReclamation typeReclamation);

	@Query("SELECT r " + "FROM reclamation r " + "WHERE r.id IN (" + "   SELECT MAX(l.id) " + "   FROM reclamation l "
			+ "   WHERE l.sender = :user OR l.recipient = :user " + "   GROUP BY " + "       CASE "
			+ "           WHEN l.recipient = :user THEN l.sender "
			+ "           WHEN l.sender = :user THEN l.recipient " + "           ELSE :user " + "       END) "
			+ "ORDER BY r.posted DESC")
	List<reclamation> findLastReclamationsByUser(@Param("user") User user);
	
	@Query("Select r from reclamation r where r.sender=:sender")
	public List<reclamation> findReclamationsBySender(@Param("sender") User sender);
	@Query("SELECT  DISTINCT sender FROM reclamation ")
	public List<User> getAllSender ();
	@Query("SELECT r FROM reclamation r WHERE r.sender.username LIKE CONCAT('%',:string,'%')")
	public List<reclamation> searchReclamation(@Param("string") String msg);


}
