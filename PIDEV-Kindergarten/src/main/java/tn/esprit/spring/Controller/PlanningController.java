package tn.esprit.spring.Controller;


import tn.esprit.spring.Services.PlanningServiceImpl;
import tn.esprit.spring.entity.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PlanningController {
	@Autowired
	PlanningServiceImpl planningservice;

	
	@PostMapping("/addPlanning")
	@ResponseBody
	public int AddPlanning(@RequestBody Planning p) {
		return planningservice.AddPlanning(p);
	}
	@PutMapping(value="/UpdatePlanning") 
	@ResponseBody
	public void updatePlannig(@RequestBody Planning p) {
		planningservice.updatePlannig(p);
	}
	 @DeleteMapping("/deletePlannig/{id}") 
		@ResponseBody 
	public void DeletePlanning(@PathVariable("id") int id) {
		planningservice.DeletePlanning(id);
	}

}
