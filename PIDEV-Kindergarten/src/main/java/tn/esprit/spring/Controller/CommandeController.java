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

import tn.esprit.spring.Services.CommandeServiceImpl;
import tn.esprit.spring.entity.Commande;

@RestController
public class CommandeController {
	@Autowired
	CommandeServiceImpl cs;
	
	@PostMapping("/command")
	@ResponseBody
	public int command(@RequestBody Commande c) {
		return cs.addCommand(c);
	}
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-factures
		@GetMapping("/retrieve-all-Commands")
		@ResponseBody
		public List<Commande> getCommand() {
		List<Commande> list = cs.retrieveAllCommands();
		 return list;
		}
		

		/*@PutMapping(value="/UpdateCommand") 
		@ResponseBody
		public void updateCommand(@RequestBody Commande c) {
			cs.updateCommand(c);
		}
		
		@DeleteMapping("/deleteCommand/{id}") 
		@ResponseBody 
		public void deleteCommand(@PathVariable("id") int id) {
			cs.deleteCommand(id);
		} */
		
}
