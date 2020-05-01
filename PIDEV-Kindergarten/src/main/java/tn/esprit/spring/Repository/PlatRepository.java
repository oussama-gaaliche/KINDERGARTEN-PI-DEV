package tn.esprit.spring.Repository;

import java.util.List;

import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlatRepository extends JpaRepository<Plat, Integer> {
	 @Query("SELECT p FROM Plat p  where p.typeplat =:tp")
	    public List<Plat> GetPlatByType( @Param("tp") TypePlat tp);
	 @Query("SELECT p FROM Plat p  where p.typeplat =:tp")
	    public Plat GetByType( @Param("tp") TypePlat tp);
	 
	 @Query("SELECT DISTINCT r.plat FROM Repas r "
				+ "join r.plat p  "
				+" where r.plat=p.id_Plat ")
	   public List<Plat> GetRepasByPlat();
	 @Query("select r.Quantity from Repas r "
	 		 +"join r.plat p  "
			+" where p.id_Plat=:p")
	    public double getQuntityByPlat(@Param("p") int p);
		
}
