package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.Services.repasServiceImpl;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Repas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepasController {
	@Autowired 
	repasServiceImpl repaservice;
	
	@GetMapping("/planreaps/{p}")
	public List<Repas> GetRepasByPlanning(@PathVariable("p") int p) {
		return repaservice.GetRepasByPlanning(p);
	}

	@GetMapping("/repas/to")
	public List<Repas> GetRepasByDate() {
		return repaservice.GetRepasByDate();
	}

	@GetMapping("/today/{date}")
	public List<Repas> repastoday(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return repaservice.repastoday(date);
	}

	@PostMapping("/addenfant")
	@ResponseBody
	 public int addenfant(@RequestBody Enfant e) {
		return repaservice.addenfant(e);
	}

	@GetMapping("/enfants")
	public List<Enfant> GetEnfantabonnée() {
		return repaservice.GetEnfantabonnée();
	}

	@PostMapping("/addrepas/{Planningid}/{date}")
	@ResponseBody
	public int addRepas(@PathVariable("Planningid") int Planningid,@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date date) {
		return repaservice.addRepas( Planningid, date);
	}

	
}
