package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.Services.PlatServiceImpl;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PlatController {
	@Autowired
	PlatServiceImpl platservice;
	
	@GetMapping("/qt/{p}")
	public double getQuntityByPlat(@PathVariable("p")int p) {
		return platservice.getQuntityByPlat(p);
	}
	@GetMapping("/montant")
	public double PrixTotalRepas() {
		return platservice.PrixTotalRepas();
	}
	@GetMapping("/platre")
	 public List<Plat> GetRepasByPlat() {
		return platservice.GetRepasByPlat();
	}
	@GetMapping("/AllPlats")
	public List<Plat> AllPlats() {
		return platservice.AllPlats();
	}
	@PostMapping("/addPlat")
	@ResponseBody
	public int AddPlat(@RequestBody Plat p) {
		return platservice.AddPlat(p);
	}
	@PutMapping(value="/UpdatePlat") 
	@ResponseBody
	public Plat updatePlat(@RequestBody Plat p) {
		return platservice.updatePlat(p);
	}
	@DeleteMapping("/deletePlat/{id}") 
	@ResponseBody 
	public void DeletePlat(@PathVariable("id") int id) {
		platservice.DeletePlat(id);
	}
	 @GetMapping("/Plats/{tp}")
	public List <Plat> GetPlanningByType(@PathVariable("tp")TypePlat tp) {
		 return platservice.GetPlatByType(tp);
	}

	
}
