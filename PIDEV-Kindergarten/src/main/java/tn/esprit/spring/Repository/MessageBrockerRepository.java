package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.MessageBrocker;



@Repository
public interface MessageBrockerRepository extends JpaRepository<MessageBrocker, Long> {
	@Query("select m  from MessageBrocker m  where ( m.userSender=:username and m.userReciver=:username1) or ( m.userSender=:username1 and m.userReciver=:username)   ORDER by m.sendDate DESC ")
	 public List<MessageBrocker> nbrmessage(@Param("username") String username,@Param("username1") String username1);


}
