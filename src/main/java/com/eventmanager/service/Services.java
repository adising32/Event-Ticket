package com.eventmanager.service;

import java.util.List;


import com.eventmanager.entities.Event;
import com.eventmanager.entities.Ticket;

public interface Services {
	
	public List<Event> getCreatedEvents(String username);

	public void saveEvent(Event theEvent);

	public List<Event> getAllEvents();

	public Event getEvent(String eventId);

	public void saveTicket(Ticket t);

}
