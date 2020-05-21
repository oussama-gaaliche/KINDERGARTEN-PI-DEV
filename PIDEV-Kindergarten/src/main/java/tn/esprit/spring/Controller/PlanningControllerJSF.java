package tn.esprit.spring.Controller;

import java.io.IOException;
import java.util.Date;


import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import tn.esprit.spring.Services.PlanningServiceImpl;
import tn.esprit.spring.entity.Planning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;


@Scope(value = "session")
@Controller(value ="planController")
@ELBeanName(value ="planController")
@Join(path = "/", to = "AffichagePlanning.jsf")
public class PlanningControllerJSF {
	
	
	
	@Autowired
	PlanningServiceImpl planningservice;
	private Planning planning;
	public Planning getPlanning() {
		return planning;
	}


	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
	private Date date_debut;
	private Date date_fin;
	
	private List<Planning> plans; 
	private int id_planning;
	private Integer PlanningToBeUpdated;
	


	public Integer getPlanningToBeUpdated() {
		return PlanningToBeUpdated;
	}


	public void setPlanningToBeUpdated(Integer planningToBeUpdated) {
		PlanningToBeUpdated = planningToBeUpdated;
	}


	public int getId_planning() {
		return id_planning;
	}


	public void setId_planning(int id_planning) {
		this.id_planning = id_planning;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String addPlanning() throws IOException{
		Planning p =new Planning();
		p.setDate_debut(date_debut);
		p.setDate_fin(date_fin);
		planningservice.AddPlanning(p);
		return "/AffichagePlanning.xhtml?faces-redirect=true";
		
		
	
		}
	public List<Planning> getPlans() {
		plans = planningservice.Getallplan();
		return plans;
		} 
	
	
	
	public void removePlanning(int id_planning)
	{
	planningservice.DeletePlanning(id_planning);	}
	
	
	
	
	
	
	public String displayPlanning(Planning p)
	{
		
	this.setDate_debut(p.getDate_debut());
	this.setDate_fin(p.getDate_fin());
	this.setPlanningToBeUpdated(p.getId_planning());
	return "/editplanning.xhtml?faces-redirect=true";
	}
	
	
	
	public String updatePlanning() 
	{ 
		planningservice.AddPlanning(new Planning (PlanningToBeUpdated,date_debut, date_fin));
		return "/AffichagePlanning.xhtml?faces-redirect=true";
		}
	
	
	
	public String goFormAdd() {
		
		return "/Add.xhtml?faces-redirect=true";
		}
		
		

	
	
	


	
}
