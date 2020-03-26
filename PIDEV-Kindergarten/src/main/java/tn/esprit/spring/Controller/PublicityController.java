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

import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.entity.Publicity;






@RestController
public class PublicityController {
	
	@Autowired
	PublicityServiceImpl publicityService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-publicities

	@GetMapping("/retrieve-all-publicities")
	@ResponseBody
	public List<Publicity> getPublicities() {
	List<Publicity> list = publicityService.retrieveAllPublicities();
	return list;

}
	
	//http://localhost:8081/SpringMVC/servlet/add-publicity
	@PostMapping("/add-publicity")
	@ResponseBody
	public Publicity addPublicity(@RequestBody Publicity p) {
	Publicity user = publicityService.addPublicity(p);
	return user;
	 }
	//http://localhost:8081/SpringMVC/servlet/remove-publicity/1
	@DeleteMapping("/remove-publicity/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int id) {
	publicityService.deletePublicity(id);
	 }
	 //http://localhost:8081/SpringMVC/servlet/modify-publicity
	@PutMapping("/modify-publicity")
	@ResponseBody
	public Publicity modifyPublicity(@RequestBody Publicity publicity) {
	return publicityService.updatePublicity(publicity);
	 }
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-publicity/1
	@GetMapping("/retrieve-publicity/{id}")
	@ResponseBody
	public Publicity retrieveUser(@PathVariable("id") int id) {
	return publicityService.retrievePublicity(id);
	}

	
}
