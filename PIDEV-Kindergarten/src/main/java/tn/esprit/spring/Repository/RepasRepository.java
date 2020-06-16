package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface RepasRepository extends JpaRepository<Repas, Integer> {
	@Query("SELECT DISTINCT r FROM Repas r  where r.repasPK.date=:date")
   public List<Repas> GetRepasByDate(@Param("date") Date date);
	@Query("SELECT DISTINCT r.repasPK FROM Repas r "
			
			+ " where r.repasPK.idplanning=:p")
   public List<RepasPk> GetRepasByPlanning(@Param("p") int p);
	@Query("SELECT DISTINCT r.plat FROM Repas r "
			+ "join r.plat p "
			+ " where p.id_plat=r.plat")
   public List<Plat> GetPlat();
	 @Modifying
	    @Transactional
	    @Query("DELETE  from Repas r where  r.repasPK.date=:date")
	    public void deleteRepasJPQL(@Param("date") Date date);
	  
	    @Query("Select "
				+ "DISTINCT r from Repas r "
				+ "join r.planning p "
				+ "where p=:ip and r.repasPK.date=p.date_debut and r.repasPK.date>=p.date_fin")
	    public List<Repas> getAllRepasByPlanning(@Param("ip") Planning ip);
	
	    @Query("Select "
				+ "DISTINCT p.repas from Planning p  "
				+ "join p.repas r "
				+ "where p.id_planning=:ip")
	    public List<Repas> getAllRepas(@Param("ip") Planning ip);
	    @Query("SELECT DISTINCT r.plat FROM Repas r "
				
			+ " where r.repasPK.date=:d")
   public List<Plat> GetPlatdate(@Param("d") Date d);
 @Query("SELECT DISTINCT r.repasPK.date FROM Repas r "
				
			+ " where r.repasPK.idplanning=:id")
   public List<Date> Getdate(@Param("id") int id);
 @Modifying
 @Transactional
 @Query("Update   Repas r Set r.plat=:plat,r.quantity=:quantity ")
 public void UpdateRepasJPQL(@Param("plat") Plat plat,@Param("quantity") int quantity);
}
