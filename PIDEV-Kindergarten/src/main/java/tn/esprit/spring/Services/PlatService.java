package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.IngredientPlatPk;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.repository.query.Param;


public interface PlatService {
	public Plat AddPlat(Plat p);
	public Plat updatePlat(Plat p);
	public void DeletePlat(int id);
	List<Plat> GetPlatByType(TypePlat tp);
	List<Plat> AllPlats();
	 public List<Plat> GetRepasByPlat();
	 public int PrixTotalRepas(RepasPk rpk);
	 public double getQuntityByPlat(int p);
	

}
