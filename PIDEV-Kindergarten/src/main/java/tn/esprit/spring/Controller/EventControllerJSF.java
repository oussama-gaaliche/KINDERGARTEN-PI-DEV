package tn.esprit.spring.Controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.Repository.ParticipationRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.IEventService;
import tn.esprit.spring.entity.Category;

import tn.esprit.spring.entity.Etat_event;
import tn.esprit.spring.entity.Etat_participation;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Role;

import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;


@Scope(value = "session")
@Controller(value ="evController")
@ELBeanName(value = "evController")
@Join(path = "/", to = "/Detail.jsf")
public class EventControllerJSF {
	
	@Autowired
	IEventService eventService;
	@Autowired
	UserRepository userreposiroty;
	@Autowired
	CommentRepository commentrepository;
	@Autowired
	EventRepository eventrepository;
	@Autowired
	ParticipationRepository participationrepository;
	
	
	private List<Event> events;
	
	
	private int id;
	private String title; 
	private String location; 
	private String photo;
	
	private Date start_date;
	private Date end_date;
	private Date date_final_reservation;
	private int nbr_places;  
	private int nbr_participants;
	private int nbr_interssants;
	private int nbr_likes;
	private int  event_budget;
	private String description;
	private Etat_event etat_event;
	private java.sql.Time event_fin_heure ;
	private Type type ;
	private int nbr_comments;
	
	private Role role;
	private Etat_participation etat;
	private Date datecomment;
	private String contenu;
	private User user_comment ;
	private Category category;
	public Category[] getCategories(){
		return Category
				.values();
	}
	
	
	public IEventService getEventService() {
		return eventService;
	}


	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	


	public Date getStart_date() {
		return start_date;
	}


	public int getNbr_comments() {
		return nbr_comments;
	}


	public void setNbr_comments(int nbr_comments) {
		this.nbr_comments = nbr_comments;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public Date getDate_final_reservation() {
		return date_final_reservation;
	}


	public void setDate_final_reservation(Date date_final_reservation) {
		this.date_final_reservation = date_final_reservation;
	}


	

	public int getNbr_places() {
		return nbr_places;
	}


	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}


	public int getNbr_participants() {
		return nbr_participants;
	}


	public void setNbr_participants(int nbr_participants) {
		this.nbr_participants = nbr_participants;
	}


	public int getNbr_interssants() {
		return nbr_interssants;
	}


	public void setNbr_interssants(int nbr_interssants) {
		this.nbr_interssants = nbr_interssants;
	}


	public int getEvent_budget() {
		return event_budget;
	}


	public void setEvent_budget(int event_budget) {
		this.event_budget = event_budget;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Etat_event getEtat_event() {
		return etat_event;
	}


	public void setEtat_event(Etat_event etat_event) {
		this.etat_event = etat_event;
	}


	public java.sql.Time getEvent_fin_heure() {
		return event_fin_heure;
	}


	public void setEvent_fin_heure(java.sql.Time event_fin_heure) {
		this.event_fin_heure = event_fin_heure;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	


	public Etat_participation getEtat() {
		return etat;
	}


	public void setEtat(Etat_participation etat) {
		this.etat = etat;
	}


	public Date getDatecomment() {
		return datecomment;
	}


	public void setDatecomment(Date datecomment) {
		this.datecomment = datecomment;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public int getNbr_likes() {
		return nbr_likes;
	}


	public void setNbr_likes(int nbr_likes) {
		this.nbr_likes = nbr_likes;
	}


	public User getUser_comment() {
		return user_comment;
	}


	public void setUser_comment(User user_comment) {
		this.user_comment = user_comment;
	}


	public List<Event> getEvent() {
		events= eventService.retrieveAllEvent();
		return events;
	}
	
	
	public void addEvent()  {
		
		
		eventService.addevent(new Event(title, location, photo,  category, start_date, end_date,date_final_reservation,type,description
				,nbr_places	,nbr_participants, nbr_interssants,event_budget,etat_event));
	};

	
	public void removeEvent(int eventId)
	{
	eventService.deleteEvent(eventId);
	};
	
	
	public String displayEvent(Event e)
	{
		this.setTitle(e.getTitle());
		this.setDescription(e.getDescription());
		this.setPhoto(e.getPhoto());
		this.setCategory(e.getCategory());
		this.setLocation(e.getLocation());
		this.setEtat_event(e.getEtat_event());
		
	
		this.setStart_date(e.getStart_date());
	
		this.setDate_final_reservation(e.getDate_final_reservation());
	
		this.setEvent_budget(e.getEvent_budget());
		
		this.setNbr_places(e.getNbr_places());
		return "/EditEvent.xhtml?faces-redirect=true";
		
	
	}
	
	public void updateEvent()
	{ eventService.updateEvent(new Event( id, title,  location,  photo,   category,  type, description,
			 start_date,    date_final_reservation,  nbr_places, 
	 event_budget,  etat_event)); }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	};
	
	
	
	public String goForm() {
		
		return "/addEvent.xhtml?faces-redirect=true";
		}
public String goDetail() {
		
		return "/Detail.xhtml?faces-redirect=true";
		}
public String goEditEvent() {
		
		return "/addEvent.xhtml?faces-redirect=true";
		}
public String goEventFront() {
	
	return "/evente.xhtml?faces-redirect=true";
	}
	
public String gottodetailevent(Event event) {
	String navigateTo ="Detail.xhtml?faces-redirect=true";
	this.setId(event.getId());
	this.setTitle(event.getTitle());
	this.setDescription(event.getDescription());
	this.setStart_date(event.getStart_date());

	this.setLocation(event.getLocation());
	this.setCategory(event.getCategory());
	this.setNbr_interssants(event.getNbr_interssants());
	this.setNbr_participants(event.getNbr_participants());

	return navigateTo;
	
	
}

public void participateevent(int id_event) {
	eventService.participer_parentjsf(id_event);
}


public void annulerparticipateevent(int id_event) throws Exception {
	eventService.annuler_participation_User_Event(id_event);
}
public void interreserevent(int id_event) {
	eventService.interesser_parentjsf(id_event);
}


  
	
public List<Event> getEventByCategorie() {

	events= eventService.getAllEventByCategorie(category);
	
	return events;
}
public List<Event> getEventByCategorie(Category category) {
	
	return eventService.getAllEventByCategorie(category);
}


}
