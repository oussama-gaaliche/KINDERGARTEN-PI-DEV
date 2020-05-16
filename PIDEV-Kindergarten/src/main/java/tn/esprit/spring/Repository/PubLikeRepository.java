package tn.esprit.spring.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.LikePub;



@Repository
public interface PubLikeRepository extends JpaRepository<LikePub, Integer> {
	<Optional> LikePub findById(int id);
	@Query("select l  from LikePub l  where ( l.user.id=:username and l.publicity.id=:username1)")
	 public LikePub likeexist(@Param("username") Long username,@Param("username1") int username1);
	//nb de like par post
	@Query("SELECT count(*) FROM LikePub lp where (lp.publicity.id =:idPublicity and lp.etat = true)")
    public int nbLike(@Param ("idPublicity") int idPublicity);
	
	//nb de dislike par post
	@Query("SELECT count(*) FROM LikePub lp where (lp.publicity.id =:idPublicity and lp.etat = false)")
	public int nbDisLike(@Param ("idPublicity") int idPublicity);
	
	
	
}
