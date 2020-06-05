package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.repository.query.Param;


public interface PlatService {
	public int AddPlat(Plat p);
	public Plat updatePlat(Plat p);
	public void DeletePlat(int id);
	List<Plat> GetPlatByType(TypePlat tp);
	List<Plat> AllPlats();
	 public List<Plat> GetRepasByPlat();
	 public double PrixTotalRepas();
	 public double getQuntityByPlat(int p);
	

}
