package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Repas;

public interface RepasService {
	public int addRepas(int Planningid,Date date);
	List<Enfant> GetEnfantabonnée();
	public int addenfant(Enfant e);
	
	List <Repas> repastoday(Date date);
	 List<Repas> GetRepasByDate();
	 List<Repas> GetRepasByPlanning(int p);

}
