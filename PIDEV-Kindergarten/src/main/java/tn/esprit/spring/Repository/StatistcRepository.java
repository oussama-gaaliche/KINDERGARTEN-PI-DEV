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
	
	@Query("select count (*) , e.jardin.nom from Enfant e group by e.jardin")  
    public List<?> listEnfantParJardin();
	
	@Query("SELECT count(*) FROM Like l where l.user.id =:userid ")  
    //public List< LikeUser> listNbLikeParUser();
	public int bLikeParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Comment c where c.user.id =:userid ")  
    public int nbComParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Post p where p.user.id =:userid ")  
    public int nbPostParUser(@Param ("userid") Long userid);
	
	@Query("SELECT count(*) FROM Participation p where p.etatParticipant='participe' and p.user.id =:userid ")  
    public int nbParticipationParUser(@Param ("userid") Long userid);
	
	@Query("select Max(u.score), u.username from User u")  
    public List<?> BestUser();
	
	@Query("SELECT u FROM User u")
	List <User> getUserList();
	
	
	//select count (*) , l.user.nom from Like l group by l.user
	
	
	

	
	
	
	
	
}
