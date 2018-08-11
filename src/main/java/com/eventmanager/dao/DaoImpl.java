package com.eventmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventmanager.entities.Event;
import com.eventmanager.entities.Ticket;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Event> getCreatedEvents(String username) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.beginTransaction();
		
		// create a query
		Query<Event> theQuery = currentSession.createQuery("from Event where eventCreator=:username", Event.class);
		theQuery.setParameter("username",username);
		List<Event> createdEvents = theQuery.getResultList();
		
		currentSession.getTransaction().commit();
		
		// return the results		
		return createdEvents;
				
	}

	@Override
	public void saveEvent(Event theEvent) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(theEvent);
		currentSession.getTransaction().commit();	
	}

	@Override
	public List<Event> getAllEvents() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.beginTransaction();
		
		Query<Event> theQuery = currentSession.createQuery("from Event", Event.class);
		List<Event> allEvents = theQuery.getResultList();
		
		currentSession.getTransaction().commit();
		
		return allEvents;
	}

	@Override
	public Event getEvent(String eventId) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Event e = currentSession.get(Event.class,eventId);
		currentSession.getTransaction().commit();
		return e;
	}

	@Override
	public void saveTicket(Ticket t) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(t);
		currentSession.getTransaction().commit();	
	}

}
