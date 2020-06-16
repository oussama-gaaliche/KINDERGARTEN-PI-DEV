package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Repository.IngredientRepository;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
	@Autowired
	IngredientRepository ingrepo;

	@Override
	public int AddIngredient(Ingredient i) {
		ingrepo.save(i);
		
		return i.getId();
	}

	@Override
	public Ingredient updateIngredient(Ingredient i) {
		ingrepo.save(i);
		return i;
	}

	@Override
	public void DeleteIngredient(int id) {
		Ingredient ing =  ingrepo.findById(id).get();
		ingrepo.delete(ing);
		
		
	}

	@Override
	public List<Ingredient> GetallIng() {
		
		return ingrepo.findAll();
	}

}
