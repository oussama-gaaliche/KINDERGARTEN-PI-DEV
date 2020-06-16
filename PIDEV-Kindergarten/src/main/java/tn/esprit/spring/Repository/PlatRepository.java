package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
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
	    public  Plat GetByType( @Param("tp") TypePlat tp);
	
	 
	 @Query("SELECT DISTINCT r.plat FROM Repas r "
				+ "join r.plat p  "
				+" where r.plat=p.id_plat and r.repasPK.date=:date")
	   public List<Plat> GetRepasByPlat(@Param("date") Date date);
	 @Query("select r.quantity from Repas r "
	 		 +"join r.plat p  "
			+" where p.id_plat=:p ")
	    public double getQuntityByPlat(@Param("p") int p);
	
	 @Query("select p.id_plat from Plat p where p.nom=:nom")
		public int GetId (@Param("nom") String nom);
	 @Query("select p.nom from Plat p  where p.id_plat=:id")
		public String GetNom (@Param("id") int id);
	 @Query("select p from Plat p  where p.nom=:nom")
		public Plat GETP (@Param("nom") String nom);
	 @Query("select p.image from Plat p  where p.id_plat=:id")
		public byte[] GETImage (@Param("id") int id);

}
