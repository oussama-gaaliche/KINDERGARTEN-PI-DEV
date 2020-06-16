package tn.esprit.spring.Controller;

import java.util.List;

import tn.esprit.spring.Services.IngretientPlatServiceImpl;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.IngredientPlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientPlatController {
	@Autowired
	IngretientPlatServiceImpl igservice;
	
	@GetMapping("/AllIng/{plat}")
	public List<Ingredient> AllIngredientByPlat(@PathVariable("plat")int plat) {
		return igservice.AllIngredientByPlat(plat);
	}
	@GetMapping("/prix")
	public String CalculPrixPlat() {
		return igservice.CalculPrixPlat();
	}
	@PostMapping("/adding/{idplat}/{iding}/{quantity}/{calories}")
	@ResponseBody
	public int addIngredientPlat(@PathVariable("idplat") int idplat,@PathVariable("iding") int iding,@PathVariable("quantity") int quantity,@PathVariable("calories") int calories) {
		return igservice.addIngredientPlat(idplat, iding, quantity, calories);
	}
	

}
