package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;


import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.User;
import org.springframework.data.repository.query.Param;

public interface PlanningSerivce {
	public int AddPlanning(Planning p);
	public Planning updatePlannig(Planning p);
	public void DeletePlanning(int id);
	 public Planning GetPlByDate(Date date);
	 public List<Planning> Getallplan();
	 public List<User> parents();
		public int GetIDPlan(Date date);
		public Planning getplanById(int Id);
		public int GetIDPlanavant( Date date);

	 public String EnvoiPlanning();
	
	

}
