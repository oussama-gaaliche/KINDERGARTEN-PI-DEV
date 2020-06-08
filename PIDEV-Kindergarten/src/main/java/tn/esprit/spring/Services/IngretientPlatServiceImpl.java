package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.spring.Repository.IngredientPlatRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.IngredientPlat;
import tn.esprit.spring.entity.IngredientPlatPk;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngretientPlatServiceImpl implements IngretientPlatService{
	@Autowired
	IngredientPlatRepository iprepo;
	@Autowired
	PlatRepository platrepo;

	@Override
	public int addIngredientPlat(int idplat, int iding, int quantity, int calories) {
		IngredientPlatPk ingpk =new IngredientPlatPk();
		ingpk.setCalories(calories);
		ingpk.setIdingredient(iding);
		ingpk.setIdplat(idplat);
		IngredientPlat ingp=new IngredientPlat();
		ingp.setIngp(ingpk);
		ingp.setQuantity(quantity);
		iprepo.save(ingp);
		return 1;
	}

	@Override
	public String CalculPrixPlat() {
		double m=0;
		List<Plat> plats=iprepo.GetIPlat();
		for(Plat p:plats){
		m=0;
		List<Ingredient> ingredients =iprepo.GetIngreidnet(p.getId_plat());
		for(Ingredient i:ingredients){
			double q;
			q=iprepo.getQuntityIngredient(i.getId(),p.getId_plat());
			m=m+i.getPrix()*q;
			p.setPrix(m);
			platrepo.save(p);
					
			}	
	}	
		return "Prix de plats modifié!";
	}

	@Override
	public List<Ingredient> AllIngredientByPlat(int plat) {
		List <Ingredient> re=new ArrayList<>();
		List<Ingredient> ingredient=iprepo.GetIngreidnet(plat);
		for (Ingredient i:ingredient)
			 re.add(i);
           return re;
		
	}

}
