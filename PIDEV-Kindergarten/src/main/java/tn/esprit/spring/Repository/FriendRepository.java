package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Follow;
import tn.esprit.spring.entity.Friend;
import tn.esprit.spring.entity.User;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	@Modifying
    @Transactional
    @Query("UPDATE Friend f SET f.verifsig =true WHERE (select count(f) from Friend f where (f.user1=:id or f.user2=:id) and f.idsign!=:id and f.sigblock=true and f.verifsig=false)>1 and(f.user1=:id or f.user2=:id)and f.sigblock=true and f.verifsig=false")
    public void BannedUser(@Param("id")Long id);
	//test
}

