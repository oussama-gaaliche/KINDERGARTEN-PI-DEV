package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.PlanningRepository;
import tn.esprit.spring.Repository.RepasRepository;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;






@Service
public class PlanningServiceImpl implements PlanningSerivce {
	@Autowired
	PlanningRepository planningrepo;
	@Autowired
	RepasRepository repasrepo;
	@Autowired
	public JavaMailSender javamailsender;
	@Autowired
	repasServiceImpl  rimpl;
	@Autowired
	EnfantRepository erepo;
	
	
	
	@Override
	public int AddPlanning(Planning p) {
		planningrepo.save(p);
		return p.getId_planning();	}

	

	@Override
	public void DeletePlanning(int id) {
		Planning planning =  planningrepo.findById(id).get();
		planningrepo.delete(planning);
		
		}

	@Override
	public Planning updatePlannig(Planning p) {
		 planningrepo.save(p);
		 return p;
	}

	@Override
	public Planning GetPlByDate(Date date) {
		return planningrepo.GetPlByDate(date);
		
	}





	@Override
	public String EnvoiPlanning() {	
		List<Repas> repas=rimpl.GetRepasByDate();
		SimpleMailMessage m=new SimpleMailMessage();
		m.setTo("chenab.takwa@gmail.com");
		m.setSubject("Planning of the day" );
		m.setText("Bonjour /n"+repas.toString());
		javamailsender.send(m);
		return "Mail envoyé !";
		
		
	}



	@Override
	public List<User> parents() {
		List<Enfant>enfants=erepo.GetEnfantabonnée();
		
		
		return null;
	} 
	




	@Override
	public List<Planning> Getallplan() {
		return planningrepo.findAll();
		
	}



	@Override
	public int GetIDPlan(Date date){
		return planningrepo.GetIDPlan(date);
	}
	public Planning getplanById(int Id) {
		return planningrepo.findById(Id).get();
		
	}



	@Override
	public int GetIDPlanavant(Date date) {
		date=new Date();
		return planningrepo.GetIDPlanavant(date) ;
	}
	 
}
