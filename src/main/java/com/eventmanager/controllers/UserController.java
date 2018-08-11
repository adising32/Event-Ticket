package com.eventmanager.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventmanager.entities.Event;
import com.eventmanager.service.Services;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Services theService;
	
	@GetMapping("/showHome")
	public String showHome(Principal principal,Model theModel) {
		List<Event> createdEvents = theService.getCreatedEvents(principal.getName());
		theModel.addAttribute("events",createdEvents);
		return "home";
	}
	
	
	@GetMapping("/createNewEvent")
	public String createNewEvent(Model theModel) {
		Event e = new Event();
		theModel.addAttribute("event",e);
		return "new-event-form";
	}
	
	@PostMapping("saveEvent")
	public String saveEvent(@ModelAttribute("event") Event theEvent, Principal principal) {
		String principalName = principal.getName();
		theEvent.setEventCreator(principalName);
		theService.saveEvent(theEvent);
		return "redirect:/user/showHome";
	}
}
















