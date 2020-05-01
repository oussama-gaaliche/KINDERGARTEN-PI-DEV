package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;


import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.PlanningRepository;
import tn.esprit.spring.Repository.RepasRepository;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class PlanningServiceImpl implements PlanningSerivce {
	@Autowired
	PlanningRepository planningrepo;
	@Autowired
	RepasRepository repasrepo;
	
	@Autowired
	repasServiceImpl  rimpl;
	@Autowired
	EnfantRepository erepo;
	
	
	
	@Override
	public int AddPlanning(Planning p) {
		planningrepo.save(p);
		return 1;
	}

	

	@Override
	public void DeletePlanning(int id) {
		planningrepo.deleteById(id);
		
		}

	@Override
	public Planning updatePlannig(Planning p) {
		 planningrepo.save(p);
		 return p;
	}

	@Override
	public List<Planning> GetPlByDate(Date date) {
		return planningrepo.GetPlByDate(date);
		
	}





	@Override
	public String EnvoiPlanning() {	
		return null;
		
		
	}



	@Override
	public List<User> parents(Long id) {
	  return erepo.parents(id);
	}

}
