package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.EvaluationRepository;
import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.Repository.FactureEventRepository;
import tn.esprit.spring.Repository.ParticipationRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Etat_participation;
import tn.esprit.spring.entity.Evaluation;
import tn.esprit.spring.entity.EvaluationPK;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.FactureEvent;
import tn.esprit.spring.entity.Participation;
import tn.esprit.spring.entity.ParticipationPK;
import tn.esprit.spring.entity.User;

@Service
public class EventServiceImpl implements IEventService {
	@Autowired
	EventRepository eventrepository;
	@Autowired
	UserRepository userrepository;
	@Autowired
	FactureEventRepository facturerepository;
	@Autowired
	ParticipationRepository participationrepository;
	@Autowired
	EvaluationRepository evaluationrepository;

	private static final Logger L = LogManager.getLogger(EventServiceImpl.class);

	///////////////// event//////////////////////////////////
	@Override
	public List<Event> retrieveAllEvent() {
		List<Event> events = (List<Event>) eventrepository.findAll();

		for (Event event : events) {
			L.info("event +++ :" + event);
		}
		return events;
	}

	@Override
	public void addevent(Event e) {
		FactureEvent facture = new FactureEvent();

		User userManagedEntity = userrepository.findById((long) 2).get();

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
		User userManagedEntity = userrepository.findById((long) 2).get();
		e.setUserseventmaker(userManagedEntity);

		return eventrepository.save(e);
	}

	@Override
	public void deleteEvent(int id) {
		eventrepository.deleteById(id);
	}

	@Override
	public Event retrieveEvent(int id) {
		Event e = eventrepository.findById((id)).orElse(null);
		return e;
	}

	////////////////////////////////////////// participation////////////////////////////////////////////////////
	@Override
	public void partciperUser_Event(int EventId, Etat_participation etat) throws Exception {
		Date date = new Date();
		Event eventManagedEntity = eventrepository.findById(EventId).get();
		Participation l = participationrepository.getParticipationByeventAnduser(2, EventId);

		if ((eventManagedEntity.getNbr_participants() < eventManagedEntity.getNbr_places())
				&& (eventManagedEntity.getDate_final_reservation().after(date))) {

			ParticipationPK participationpk = new ParticipationPK();
			participationpk.setIdEventt(EventId);
			participationpk.setIduserr(2);
			Participation participation = new Participation();
			participation.setParticipationpk(participationpk);
			participation.setEtat(etat);
			participation.setDate_participation(date);

			if (etat.equals(Etat_participation.participe)) {
				if (eventManagedEntity.getParticipations().contains(l)) {
					if (l.getEtat().equals(etat)) {
						throw new Exception("cet evenement  avec l'id " + EventId + " est deja " + etat);
					} else {
						eventManagedEntity.setNbr_participants(eventManagedEntity.getNbr_participants() + 1);

						eventrepository.save(eventManagedEntity);
					}
					if (l.getEtat().equals(Etat_participation.interessee)) {
						eventManagedEntity.setNbr_interssants(eventManagedEntity.getNbr_interssants() - 1);
						eventrepository.save(eventManagedEntity);
					}
				}
			}

			if (etat.equals(Etat_participation.interessee)) {
				if (eventManagedEntity.getParticipations().contains(l)) {

					if (l.getEtat().equals(etat)) {
						throw new Exception("cet evenement  avec l'id " + EventId + " est deja " + etat);
					}
				} else {
					eventManagedEntity.setNbr_interssants(eventManagedEntity.getNbr_interssants() + 1);
					eventrepository.save(eventManagedEntity);
				}
			}

			// if (eventManagedEntity.getParticipations().contains(l) ) {

			// if (l.getEtat().equals(etat)) {
			// throw new Exception("cet evenement avec l'id " + EventId + " est
			// deja "+etat) ;
			// }}
			// else
			// {
			participationrepository.save(participation);
		}

		else
			throw new Exception(
					"cet evenement  avec l'id " + EventId + " est plein ou la date finale de reservation est atteint");
	}
	// }

	@Override
	public void annuler_participation_User_Event(int EventId) throws Exception {
		Date date = new Date();
		// User user = userrepository.findById((long)5).get() ;
		Event eventManagedEntity = eventrepository.findById(EventId).get();
		// String k =
		// participationrepository.getEtat_participationByParticipatio(5,
		// EventId);
		Participation l = participationrepository.getParticipationByeventAnduser(2, EventId);

		if (eventManagedEntity.getParticipations().contains(l)) {
			if (l.getEtat().equals(Etat_participation.participe)) {

				if (eventManagedEntity.getStart_date().after(date)) {
					eventManagedEntity.setNbr_participants(eventManagedEntity.getNbr_participants() - 1);
					participationrepository.deleteParticipationByiduserandIdevent(2, EventId);
					eventrepository.save(eventManagedEntity);
				} else
					throw new Exception("cet evenement avec l'id " + EventId + "est deja en cours");
			} else
				throw new Exception("vous etes pas participer a cette event avec l'id " + EventId);

		} else
			throw new Exception("vous etes pas inscrit  cette event avec l'id " + EventId);

	}

	@Override
	public void evaluer_event(int eventId, int valeur) throws Exception {
		Date date = new Date();
		Event eventManagedEntity = eventrepository.findById(eventId).get();
		User user = userrepository.findById((long)7).get() ;
	    Participation l = participationrepository.getParticipationByeventAnduser(7, eventId) ;

	    if (eventManagedEntity.getParticipations().contains(l) ) {
	    	if (l.getEtat().equals(Etat_participation.participe)){
		EvaluationPK evaluationpk = new EvaluationPK();
		evaluationpk.setIdEvent(eventId);
		evaluationpk.setIduser(7);
		
		Evaluation evaluation = new Evaluation();
		evaluation.setEvaluationpk(evaluationpk);
		evaluation.setEvaluation_date(date);
		evaluation.setEvaluation_value(valeur);
		evaluationrepository.save(evaluation);
    //    eventrepository.save(eventManagedEntity);
     //   userrepository.save(user);
	    }
	    	else throw new Exception ("vous etes pas participer a cet evenement");
	    }
	    else throw new Exception ("pas inscrit a cette evenement");
		
	}

	@Override
	public int top_evaluation_event() {
		return evaluationrepository.top_evaluation_event();
	}

	@Override
	public int getNombreEmployeJPQL() {
		return evaluationrepository.countemp();
	}

	@Override
	public int getNombresevents(User user) {
		return eventrepository.countevents(user);
	}

	@Override
	public List<Event> getAllEventOrdonneParDate() {
		   User user = userrepository.findById((long) 1).get();
	      
			return eventrepository.getAllEventOrdonneParDate(1);
	}

	@Override
	public List<Event> getAllEventPourToday() {
		return eventrepository.getAllEventPourToday();
	}

	@Override
	public Event getEventById(int eventId) {
		return eventrepository.findById(eventId).get();	
	}

	@Override
	public List<Event> getAllEventByCategorieAndNom(Category category, String titre) {
		return eventrepository.getAllEventByCategorieAndNom(category,titre);
		
	}
	@Override
	public List<Event> getAllEventByCategorie(Category category)  {
		return eventrepository.getAllEventByCategorie(category);
		
	}
	@Override
	public List<Event> getAllEventByNom(String titre) {
		return eventrepository.getAllEventByNom(titre);
		
	}

}
