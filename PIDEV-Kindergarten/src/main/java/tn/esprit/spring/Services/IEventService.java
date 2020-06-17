
package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Etat_participation;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.User;

public interface IEventService {

	public List<Event> retrieveAllEvent();

	public void addevent(Event e);

    public 	Event updateEvent(Event e);

	public void participer_parentjsf(int id_event);
	public void interesser_parentjsf(int id_event);
    public 	void deleteEvent(int id);
    
    
	
	
	public Event retrieveEvent(int id);
	
	//////Participation/////
   public void partciperUser_Event (int EventId,Etat_participation etat) throws Exception;
	
	public void annuler_participation_User_Event (int EventId) throws Exception;
	
  public void evaluer_event(int eventId,int valeur) throws Exception ;
	
	public int top_evaluation_event();
	
	public int getNombreEmployeJPQL();
	
	public int getNombresevents(User user);
	
	public Event getEventById(int eventId);
	
	public List<Event> getAllEventOrdonneParDate();
    
	    public List<Event> getAllEventPourToday();
		public List<Event>getAllEventByCategorieAndNom(Category category,String titre);
		
		public List<Event>getAllEventByCategorie(Category category);

		public List<Event>getAllEventByNom(String titre);
}
