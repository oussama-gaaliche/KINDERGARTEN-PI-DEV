package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.entity.Publicity;

@RestController
public class PublicityController {

	@Autowired
	PublicityServiceImpl publicityService;

	// affichage des pub ( depend des prix des sponsoring)
	@GetMapping(value = "/retrieve-all-publicities")
	@ResponseBody
	public List<Publicity> getPublicities() {

		return publicityService.retrieveAllPublicitiesPub();

	}

	@PostMapping("/add-publicity")
	@ResponseBody
	public String addPublicity(@RequestBody Publicity p) {

		return publicityService.addPublicity(p);

	}

	@PutMapping("/update-publicity")
	@ResponseBody
	public String modifyPublicity(@RequestBody Publicity p) {

		return publicityService.addPublicity(p);

	}

	@DeleteMapping("/remove-publicity/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int id) {
		publicityService.deletePublicity(id);
	}

	// afficher les publicités cibles (pub depend du user)

	@GetMapping(value = "retrieve-all-publicities/{id}")
	@ResponseBody
	public List<Publicity> getPublicities(@PathVariable("id") Long id) {

		return publicityService.retrieveAllPublicities(id);

	}

	// decrementation

	@RequestMapping(method = RequestMethod.PUT, value = "modify-publicity")

	public void modifyPublicity() {
		publicityService.updatePublicity();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-publicity/1

	@GetMapping("/retrieve-publicity/{id}")
	@ResponseBody
	public Publicity retrieveUser(@PathVariable("id") int id) {
		return publicityService.retrievePublicity(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "modify-rating")

	public void modifyRating() {
		publicityService.updateRating();
	}

}
