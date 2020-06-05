package tn.esprit.spring.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.User;
@Repository
public interface StatistcRepository extends JpaRepository<User, Long> {
	
	@Query("select count (*) , YEAR(u.dateInscription) from User u group by YEAR(u.dateInscription) ")
    public List<?> listUser();

	@Query("select count (u) , YEAR(u.dateInscription) , MONTH(u.dateInscription) from User u group by YEAR(u.dateInscription), MONTH(u.dateInscription) ")
    public List<?> listMois1();
	
	@Query("select count (*), e.niveau , e.classe , e.jardin.nom from Enfant e group by e.niveau , e.classe , e.jardin.nom order by e.jardin.nom ")  
    public List<?> listEnfantParNiveau();
	
	@Query("select  e.jardin.nom, count (*) from Enfant e group by e.jardin")  
    public List<?> listEnfantParJardin();
	
	@Query("SELECT count(*) FROM Like l where l.user.id =:userid ")  
    //public List< LikeUser> listNbLikeParUser();
	public int bLikeParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Comment c where c.user.id =:userid ")  
    public int nbComParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Post p where p.user.id =:userid ")  
    public int nbPostParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Participation p where p.etat='participe' and p.user_participation.id=:userid ")  
    public int nbParticipationParUser(@Param ("userid") Long userid);
	
	@Query("select Max(u.score), u.username from User u")  
    public List<?> BestUser();
	
	@Query("SELECT u FROM User u")
	List <User> getUserList();
	
	@Query("SELECT count(*) FROM Enfant e where e.jardin.id =:jardinid ")  
	public int nbEnfantParJardin(@Param ("jardinid") Long jardinid);
	
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2020 and e.jardin.id =:jardinid")
    public int NbUser2020(@Param ("jardinid") Long jardinid);
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2019 and e.jardin.id =:jardinid")
    public int NbUser2019(@Param ("jardinid") Long jardinid);
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2018 and e.jardin.id =:jardinid")
    public int NbUser2018(@Param ("jardinid") Long jardinid);
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2020 and MONTH(e.user.dateInscription)=:month")
    public int NbUser2020ByMonth(@Param ("month") int month);
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2019 and MONTH(e.user.dateInscription)=:month")
    public int NbUser2019ByMonth(@Param ("month") int month);
	
	

	
	
	
	
	
}
