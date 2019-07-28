package com.citi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.service.CommunicatorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommunicatorController {

	@Autowired
	CommunicatorService service;

	@PostMapping("/events/reminders/signupEvent")
	@ResponseBody
	public Map<String, String>  signupEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		return service.emailSubscription(EventID, UserID, "Sign Up Event");
	}

	@RequestMapping("/events/reminders/reminderEvent")
	@ResponseBody
	public Map<String, String> reminderEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		return service.emailSubscription(EventID, UserID, "Event Reminder");
	}

	@RequestMapping("/events/reminders/upcomingEvent")
	@ResponseBody
	public Map<String, String> upcomingEvent(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		return service.emailSubscription(EventID, UserID, "Upcoming Event");
	}

	// Insert Template
	@RequestMapping("/events/reminders/insertNotificationSubscription")
	@ResponseBody
	public Map<String, String> insertNotificationSubscription(@RequestParam("EventID") int EventID, 
			@RequestParam("Subject") String subject, @RequestParam("Content") String content) {
		return service.insertNotificationSubscription(EventID, subject, content);
	}

	// Organisation
	@RequestMapping("/events/reminders/fullSubscription")
	@ResponseBody
	public Map<String, String> fullSubscription(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID) {
		return service.emailSubscription(EventID, UserID, "Full Subscription");
	}

	@RequestMapping("/index")
	String index() {

		return "Well Done!! Nice Try!! Good bye!";
	}
}
