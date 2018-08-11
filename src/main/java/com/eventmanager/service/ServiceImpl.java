package com.eventmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventmanager.dao.Dao;
import com.eventmanager.entities.Event;
import com.eventmanager.entities.Ticket;

@Service
public class ServiceImpl implements Services {
	
	@Autowired
	private Dao theDao;

	@Override
	@Transactional
	public List<Event> getCreatedEvents(String username) {
		
		return theDao.getCreatedEvents(username);
	}

	@Override
	public void saveEvent(Event theEvent) {
		theDao.saveEvent(theEvent);
	}

	@Override
	public List<Event> getAllEvents() {
		return theDao.getAllEvents();
	}

	@Override
	public Event getEvent(String eventId) {
		return theDao.getEvent(eventId);
	}

	@Override
	public void saveTicket(Ticket t) {
		theDao.saveTicket(t);
	}

}
