package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepasRepository extends JpaRepository<Repas, Integer> {
	@Query("SELECT DISTINCT r FROM Repas r  where r.RepasPK.date=:date")
   public List<Repas> GetRepasByDate(@Param("date") Date date);
	@Query("SELECT DISTINCT r FROM Repas r "
			+ "join r.planning p "
			+ " where p.id_planning=:p")
   public List<Repas> GetRepasByPlanning(@Param("p") int p);
	@Query("SELECT DISTINCT r.plat FROM Repas r "
			+ "join r.plat p "
			+ " where p.id_Plat=r.plat")
   public List<Plat> GetPlat();
	
	
}
