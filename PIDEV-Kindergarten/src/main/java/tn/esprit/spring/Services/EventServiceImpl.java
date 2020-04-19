package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.Repository.FactureEventRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.FactureEvent;
import tn.esprit.spring.entity.User;


@Service
public class EventServiceImpl implements IEventService{
	@Autowired
	EventRepository  eventrepository;
	@Autowired
	UserRepository userrepository;
	@Autowired
	FactureEventRepository facturerepository;
	private static final Logger L = LogManager.getLogger(EventServiceImpl.class);
	@Override
	public List<Event> retrieveAllEvent() {
		List<Event> events =(List<Event>) eventrepository.findAll();
		
		for (Event event : events) {
			L.info("event +++ :" + event);
		}
		return events;
	}

	@Override
	public void addevent(Event e) {
		FactureEvent facture = new FactureEvent();
		  
	     User userManagedEntity = userrepository.findById((long) 1).get();
 
	    e.setUserseventmaker(userManagedEntity);
	   	e.setNbr_participants(0);
	    facture.setMontant_totale(0);
		facture.setMontant_locale(0);
		facture.setMontant_stocks(0);
		facture.setDate_facture(null);
		facturerepository.save(facture);
		e.setFacture(facture);
		eventrepository.save(e);
		
	}

	@Override
	public Event updateEvent(Event e) {
		 User userManagedEntity = userrepository.findById((long) 1).get();
		    e.setUserseventmaker(userManagedEntity);

		return eventrepository.save(e);
	}

	@Override
	public void deleteEvent(int id) {
		eventrepository.deleteById(id);
		
	}

	@Override
	public Event retrieveEvent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
