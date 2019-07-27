package com.citi.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.service.CommunicatorService;

@RestController
public class CommunicatorController {
	
	@Autowired
	CommunicatorService service;
	
	@RequestMapping("/events/reminders/signupEvent")
	public String signupEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		String result = service.emailSubscription(EventID, UserID, "Sign Up Event");
		return "Success";
	}
	
	@RequestMapping("/events/reminders/reminderEvent")
	public String reminderEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		String result = service.emailSubscription(EventID, UserID, "Event Reminder");
		return "Success";
	}
	
	@RequestMapping("/events/reminders/upcomingEvent")
	public String upcomingEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		String result = service.emailSubscription(EventID, UserID, "Upcoming Event");
		return "Success";
	}
	
	
	// Organisation
	@RequestMapping("/events/reminders/fullSubscription")
	public String fullSubscription(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		String result = service.emailSubscription(EventID, UserID, "Full Subscription");
		return "Success";
	}
	
	
	
	@RequestMapping("/index")
    String index() {
        
		
        return "Well Done!! Nice Try!! Good bye!";
    }
}
