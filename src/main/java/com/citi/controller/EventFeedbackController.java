package com.citi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.service.EventFeedbackService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventFeedbackController {

	@Autowired
	EventFeedbackService service;
	
	@PostMapping("/events/feedbacks/create")
	@ResponseBody
	public Map<String, String> createEventFeedback(@RequestParam("EventID") int EventID, @RequestParam("UserID") int UserID,
			@RequestParam("Feedback") String Feedback) {
		return service.createEventFeedback(EventID, UserID, Feedback);
	}
	
	@GetMapping("/events/feedbacks/{eventID}")
	@ResponseBody
	public List<Map<String, String>> viewEventFeedback(@PathVariable("eventID") int eventID){
		return service.viewEventFeedbacks(eventID);		
	}
	
	@GetMapping("/events/feedbacks/{eventID}/{feedbackID}")
	@ResponseBody
	public Map<String, String> viewEventFeedbacks(@PathVariable("eventID") int eventID, @PathVariable("feedbackID") int feedbackID){
		return service.viewEventFeedback(eventID, feedbackID);		
	}
}
