package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
	@Query("select p  from Reaction p  where ( p.user.id=:idUser and p.post.id=:idPost)")
	 public Reaction reactionExist(@Param("idUser") Long idUser,@Param("idPost") Long idPoste);

}
