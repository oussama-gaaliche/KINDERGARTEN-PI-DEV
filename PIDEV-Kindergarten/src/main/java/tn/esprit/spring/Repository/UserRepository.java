package tn.esprit.spring.Repository;


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
//	@Modifying
//    @Transactional
//    @Query("UPDATE user u SET u.active=:etat where e.id=:employeId and e.roles like 'RESPONSABLE'")
//    public void ValidResponsable(@Param("etat")Boolean etat, @Param("employeId")long employeId);
}
