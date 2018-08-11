package com.eventmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eventmanager.entities.Event;
import com.eventmanager.entities.Ticket;
import com.eventmanager.service.Services;

@Controller
@RequestMapping("/forAll")
public class ForAllController {
	
	@Autowired
	private Services theService;
	
	@GetMapping("/viewEvents")
	public String viewEvents(Model theModel) {
		List<Event> allEvents = theService.getAllEvents();
		theModel.addAttribute("events",allEvents);
		return "all-events";
	}
	
	@GetMapping("/buyTicket")
	public String buyTicket(Model theModel, @RequestParam("eventId") String eventId) {
		Event e = theService.getEvent(eventId);
		String ticketId = "TI"+e.getEventId()+e.getTicketsRemaining();
		Ticket t = new Ticket(ticketId,eventId);
		theService.saveTicket(t);
		return "booking-cnf";
	}
}
