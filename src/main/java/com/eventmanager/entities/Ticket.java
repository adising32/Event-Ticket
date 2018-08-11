package com.eventmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="ticket_id")
	private String ticketId;
	
	@Column(name="event_id")
	private String eventId;
	
	public Ticket(String ticketId, String eventId) {
		super();
		this.ticketId = ticketId;
		this.eventId = eventId;
	}
	
	public String getTicketId() {
		return ticketId;
	}


	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}


}
