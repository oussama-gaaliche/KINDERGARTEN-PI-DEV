package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.FactureServiceImpl;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Facture;

@RestController
public class FactureController {
	@Autowired
	FactureServiceImpl fs;
	
	@PostMapping("/addFacture")
	@ResponseBody
	public int addFacture(@RequestBody Facture f) {
		return fs.addFacture(f);
	}
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-factures
		@GetMapping("/retrieve-all-factures")
		@ResponseBody
		public List<Facture> getFactures() {
		List<Facture> list = fs.retrieveAllFacture();
		 return list;
		}
		

		@PutMapping(value="/UpdateFacture") 
		@ResponseBody
		public void updateFacture(@RequestBody Facture f) {
			fs.updateFacture(f);
		}
		
		@DeleteMapping("/deleteFacture/{id}") 
		@ResponseBody 
		public void deleteFacture(@PathVariable("id") int id) {
			fs.deleteFacture(id);
		}
}
