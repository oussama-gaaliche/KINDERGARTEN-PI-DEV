package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.PostStatService;


@RestController
public class PostStatController {
	@Autowired
	PostStatService statService;
	
	@GetMapping(value ="/poststat")
	public List<?> retrieveWord() {
	
	return statService.retrieveWord();

}
	@GetMapping(value ="/poss")
	public void setRepition() {
	
	 statService.setRepition();

}
	@GetMapping(value ="/posst")
	public String[] seleccontained() {
	
	return  statService.seleccontained();
	}

	}
