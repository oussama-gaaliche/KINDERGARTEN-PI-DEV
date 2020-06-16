package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.IngredientPlat;
import org.springframework.data.repository.query.Param;

public interface IngretientPlatService {
	public int addIngredientPlat(int idplat,int iding,int quantity,int calories);
	public String CalculPrixPlat();
	public List<Ingredient> AllIngredientByPlat( int plat);
	public List<IngredientPlat> getAll();
}
