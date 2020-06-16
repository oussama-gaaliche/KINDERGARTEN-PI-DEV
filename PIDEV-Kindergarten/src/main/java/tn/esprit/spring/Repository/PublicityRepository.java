package tn.esprit.spring.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;
@EnableScheduling
public interface PublicityRepository extends JpaRepository<Publicity, Integer> {
@Query("select p from Publicity p join p.User u join u.enfant e where upper(p.category)=upper(e.loisir) and u.id=:id order by p.priceSponsoring desc")
public List<Publicity> listPub(@Param("id") Long id);
	@Query("select p from Publicity p where p.priceSponsoring>200 ")
    public List<Publicity> listPub();
	//rating
	//nombredes utlisateurs qui ont voté
	@Query("SELECT count(*) FROM Rating r where r.publicity.id =:idPublicity")  
    public int nbUserNote(@Param ("idPublicity") int idPublicity);
	//somme des notes
	@Query("SELECT SUM(r.note) FROM Rating r where r.publicity.id =:idPublicity")  
    public float SommeNote(@Param ("idPublicity") int idPublicity);
	@Query("SELECT u FROM User u")
	List <User> getUserList();
	
	@Query("select p.image from Publicity p where p.id=:id")
	public byte[] getImage(@Param("id") int id);
	
	@Query("select p.average from Publicity p where p.id=:id")
	public float getRating(@Param("id") int id);
	
	@Query("SELECT p FROM Publicity p WHERE p.productName LIKE CONCAT('%',:string,'%')")
	public List<Publicity> searchPublicity(@Param("string") String msg);
	
	@Query("SELECT p FROM Publicity p WHERE p.productName=: string")
	public Publicity getPubByName(@Param("string") String msg);
}