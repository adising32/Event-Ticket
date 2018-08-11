package com.eventmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	
	@Id
	@Column(name="event_id")
	private String eventId;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_creator")
	private String eventCreator;
	
	@Column(name="tickets_remaining")
	private int ticketsRemaining;
	
	public Event() {
	
	}

	public Event(String eventId, String eventName, String eventCreator) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventCreator = eventCreator;
	}

	
	
	public int getTicketsRemaining() {
		return ticketsRemaining;
	}

	public void setTicketsRemaining(int ticketsRemaining) {
		this.ticketsRemaining = ticketsRemaining;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventCreator() {
		return eventCreator;
	}

	public void setEventCreator(String eventCreator) {
		this.eventCreator = eventCreator;
	}
	
	
}
