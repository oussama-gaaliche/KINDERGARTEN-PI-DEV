package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.IEventService;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Etat_participation;
import tn.esprit.spring.entity.Event;

@RestController
public class EventController {
	@Autowired
	IEventService ieventservice;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-events
	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
		List<Event> list = ieventservice.retrieveAllEvent();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-event/{event-id}
	@GetMapping(path = "/retrieve-event/{event-id}")
	@ResponseBody
	public Event retrieveEvent(@PathVariable("event-id") int eventId) {
		return ieventservice.retrieveEvent(eventId);
	}

	// Ajouter Event : http://localhost:8081/SpringMVC/servlet/add-event
	@PostMapping("/add-event")
	@ResponseBody
	public void addEvent(@RequestBody Event e) {
		ieventservice.addevent(e);
	}

	// http://localhost:8081/SpringMVC/servlet/remove-event/{event-id}
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeUser(@PathVariable(name = "event-id") int eventId) {
		ieventservice.deleteEvent(eventId);
	}

	// http://localhost:8081/SpringMVC/servlet/modify-event
	@PutMapping("/modify-event")
	@ResponseBody
	public Event modifyEvent(@RequestBody Event event) {
		return ieventservice.updateEvent(event);
	}
	////////////////////////////////////////// participation////////////////////////////////////////////////////////

	// http://localhost:8081/SpringMVC/servlet/affecteruserAevent/1/1
	@PutMapping(value = "/participeruserAevent/{idevent}/{etat}")
	public void participeruseraevent(@PathVariable("idevent") int eventId,
			@PathVariable("etat") Etat_participation etat) throws Exception {
		ieventservice.partciperUser_Event(eventId, etat);

	}

	// http://localhost:8081/SpringMVC/servlet/annuler_participation_User_Event/1/1
	@PutMapping(value = "/annuler_participation_User_Event/{idevent}")
	public void desaffecterEmployeDuDepartement(@PathVariable("idevent") int eventId) throws Exception {
		ieventservice.annuler_participation_User_Event(eventId);

	}

	@PostMapping("/evaluer_event/{eventId}/{valeur}")
	@ResponseBody
	public void evaluer_event(@PathVariable("eventId") int eventId, @PathVariable("valeur") int valeur)
			throws Exception {
		ieventservice.evaluer_event(eventId, valeur);

	}

	// http://localhost:8081/SpringMVC/servlet/top_evaluation_event
	@GetMapping(value = "/top_evaluation_event")
	@ResponseBody
	public Event gettop_evaluation_event() {
		int l = ieventservice.top_evaluation_event();
		Event event = ieventservice.getEventById(l);
		return event;

	}

	// URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
	@GetMapping(value = "/getNombreEmployeJPQL")
	@ResponseBody
	public int getNombreEmployeJPQL() {

		return ieventservice.getNombreEmployeJPQL();
	}

	// URL : http://localhost:8081/SpringMVC/servlet/getNombreseventsbyiduser
	/*
	 * @GetMapping(value = "/getNombreseventsbyiduser/{iduser}")
	 * 
	 * @ResponseBody public int getNombreseventsbyiduser(@PathVariable("Iduser")
	 * int iduser) { User
	 * user=ientrepriseservice.getEntrepriseById(identreprise); return
	 * ieventservice.getNombresevents(iduser); }
	 */

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsordonnebydate
	@GetMapping(value = "/retrieve-all-events_by_date")
	@ResponseBody
	public List<Event> getAll_EventsBydate() {
		return ieventservice.getAllEventOrdonneParDate();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-eventpourToday
	@GetMapping(value = "/retrieve-all-events_of_today")
	@ResponseBody
	public List<Event> getAll_Eventsoftoday() {
		return ieventservice.getAllEventPourToday();
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsbycategorie_and_nom
    	@GetMapping(value="/retrieve-all-events_by_categorie_and_nom/{categorie}/{titre}")
    	@ResponseBody
    	public List<Event> getAll_EventsByCategorieAndNom(@PathVariable("categorie") Category category,@PathVariable("titre") String titre) {
    	return ieventservice.getAllEventByCategorieAndNom(category,titre);
    	}
    	//http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsbycategorie
    	@GetMapping(value="/retrieve-all-events_by_categorie/{categorie}")
    	@ResponseBody
    	public List<Event> getAll_EventsByCategorie(@PathVariable("categorie") Category category) {
    	return ieventservice.getAllEventByCategorie(category);
    	}
    	//http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsbynom
    	@GetMapping(value="/retrieve-all-events_by_nom/{titre}")
    	@ResponseBody
    	public List<Event> getAll_EventsByNom(@PathVariable("titre") String titre) {
    	return ieventservice.getAllEventByNom(titre);
    	
    	 }      
    	

}
