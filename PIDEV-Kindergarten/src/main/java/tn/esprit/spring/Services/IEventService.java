package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Event;

public interface IEventService {
	public List<Event> retrieveAllEvent();

	public void addevent(Event e);

public 	Event updateEvent(Event e);


public 	void deleteEvent(int id);
	
	
	public Event retrieveEvent(int id);

}
