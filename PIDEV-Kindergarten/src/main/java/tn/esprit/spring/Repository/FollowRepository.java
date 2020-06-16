
package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Follow;
import tn.esprit.spring.entity.MessageBrocker;
import tn.esprit.spring.entity.User;



@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer>  {
	@Query("select count(f)  from Friend f  where (f.user1=:id or f.user2=:id) and idsign!= :id and sigblock=true  ")
	 public List<MessageBrocker> nbrmessage(@Param("id") Long id);

	
	List<Follow> findFollowByUserReciver(User user);
	@Query("select f  from Follow f  where f.id_Sender=:id and f.userReciver.username=:username")
	 public List<Follow> cherchefollow(@Param("id") Long id,@Param("username") String username);
	
//	@Query(nativeQuery = true, value ="select `id`, `date_rating`, `review`, `publicity_id`, `user_id`, `note` from rating where id order by date_rating desc limit 3")
//	public List<Rating> listLastReviews(@Param("id") int id);
}

