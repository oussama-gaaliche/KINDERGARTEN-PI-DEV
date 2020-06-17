package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.EtatNotif;
import tn.esprit.spring.entity.Notification;
@Repository
public interface NotifRepository extends JpaRepository<Notification, Long>{
	@Query("select n FROM Notification n where (n.etat = :etat)")
	List<Notification> retrieveNotifByEtat(@Param("etat") EtatNotif etat);
}
