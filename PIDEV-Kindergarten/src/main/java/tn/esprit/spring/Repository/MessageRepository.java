package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.Oppor;
import tn.esprit.spring.entity.User;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	 @Query("select m.userReciver  from Message m  where  CURRENT_DATE - m.date <=7 and (m.sender=:username )   GROUP by m.userReciver ORDER by count(m) DESC ")
	 public List<User> lista(@Param("username") String username);
	 
	 
	 
	 //select u.id,count(m) from Message m join m.userReciver u where CAST(CURRENT_TIMESTAMP AS DATE)-date <=7 GROUP by m.userReciver ORDER by date DESC
  // public void ValidResponsable(@Param("etat")Boolean etat, @Param("employeId")long employeId);
	
//@Query("select DISTINCT m from Mission m join m.timesheets t join t.employe e where e.id=:employeId")
}
