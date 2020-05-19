package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.Planning;

public interface IngredientService {
	public int AddIngredient(Ingredient i);
	public Ingredient updateIngredient(Ingredient i);
	public void DeleteIngredient(int id);
	 
	 public List<Ingredient> GetallIng();

}
