
package tn.esprit.spring.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	User findUserByUsername(String username);
	 @Modifying
	    @Transactional
	    @Query("UPDATE User u SET u.nbrsig =u.nbrsig+1,u.active=0 WHERE (select count(f) from Friend f where (f.user1=:id or f.user2=:id) and f.idsign!=:id and f.sigblock=true and f.verifsig=false)>1 and(id=:id)")
	    public void BannedUser(@Param("id")Long id);
	 
	 @Query("select  u from User u WHERE u.username=:usernam")
	    public List<User> rechercheuser(@Param("usernam") String user);
	 @Query("select  u from User u WHERE u.username=:usernam")
	    public User userconnect(@Param("usernam") String user);
	 
	 @Query("select  u from User u WHERE u.id=:id")
	    public User userfollow(@Param("id") Long user);
}

