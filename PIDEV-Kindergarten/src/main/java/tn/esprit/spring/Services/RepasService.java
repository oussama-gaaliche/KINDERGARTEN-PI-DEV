package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import org.springframework.data.repository.query.Param;

public interface RepasService {
	public int addRepas(int Planningid,Date date);
	List<Enfant> GetEnfantabonnée();
	public int addenfant(Enfant e);
	public void deleteRepas(Date date);
	List <Repas> repastoday(Date date);
	 List<Repas> GetRepasByDate();
	 List<RepasPk> GetRepasByPlanning(int p);
	 List<Repas> GetAllRepas();
	// public void deleteRepasJPQL( Date date);
	// public List<Repas> getAllRepasByPlanning(Planning p);
	 
	 public Repas updateRepas(Repas repas);


}
