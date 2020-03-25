package tn.esprit.spring.Services;

import tn.esprit.spring.Repository.PlanningRepository;
import tn.esprit.spring.entity.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 public class PlanningServiceImpl implements IPlanningSerivce{
	@Autowired
	PlanningRepository planningrepo;

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

}
