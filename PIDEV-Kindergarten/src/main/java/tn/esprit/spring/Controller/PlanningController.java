package tn.esprit.spring.Controller;


import tn.esprit.spring.Services.PlanningServiceImpl;
import tn.esprit.spring.entity.Planning;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	@GetMapping("/Parents/{id}")
	public List<User> parents(@PathVariable("id")Long id) {
		return planningservice.parents(id);
	}


	@GetMapping("/SendEmail")
	public String EnvoiPlanning() {
		return planningservice.EnvoiPlanning();
	}

	
	@GetMapping("/p/{date}")
	public List<Planning> GetPlByDate(@PathVariable("date") @DateTimeFormat(pattern ="yyyy-MM-dd") Date date) {
		return planningservice.GetPlByDate(date);
	}
	
	
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


