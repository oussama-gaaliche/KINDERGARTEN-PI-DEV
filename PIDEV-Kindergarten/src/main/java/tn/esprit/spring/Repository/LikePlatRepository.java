package tn.esprit.spring.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tn.esprit.spring.entity.LikePlat;
import tn.esprit.spring.entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LikePlatRepository extends JpaRepository<LikePlat,Integer> {
	<Optional> LikePlat findById(int id);
	@Query("select l  from LikePlat l  where ( l.user.id=:username and l.plat.id_plat=:username1)")
	 public LikePlat likeexist(@Param("username") long username,@Param("username1") int username1);
	@Query("select l.plat  from LikePlat l  where ( l.user.id=:id)")
	 public List<Plat> listfavoris(@Param("id") long id);
	@Query("select l.id from LikePlat l  where (l.user.id=:id and l.plat.id_plat=:idp)")
	 public int idlikep(@Param("id") int id,@Param("idp") int idp);
	//nb de like par plat
	@Query("SELECT count(*) FROM LikePlat lp where (lp.plat.id_plat =:idP and lp.etat = true)")
    public int nbLike(@Param ("idP") int idP);
	
	//nb de dislike par plat
	@Query("SELECT count(*) FROM LikePlat lp where (lp.plat.id_plat =:idP and lp.etat = false)  ")
	public int nbDisLike(@Param ("idP") int idP);
	@Query(value="SELECT max(plat_id_plat)as maxi  FROM tLikePlat lp"+" where (lp.etat=true) ORDER BY maxi desc limit 2" ,nativeQuery=true)
	public int meilleurPlat();
	
	@Query("SELECT count(*) as ok,lp.plat FROM LikePlat lp where lp.etat = true group by lp.plat ORDER BY ok desc ")
	public  List<?> Platparjm();
	@Query("SELECT lp.plat, count(*) as ok FROM LikePlat lp where lp.etat = true group by lp.plat ORDER BY ok desc ")
	public  List<Plat> Platplopulaire();
     	
	

}
