package com.citi.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.service.EventService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {
	
	@Autowired
	EventService service;
	
	@PostMapping("/events/create")
	@ResponseBody
	public Map<String, String> createEvent(@RequestParam("OrganiserID") String OrganiserID, @RequestParam("EventName") String EventName,
			@RequestParam("EventDescription") String EventDescription, @RequestParam("StartTime") String StartTime,
			@RequestParam("EndTime") String EndTime, @RequestParam("MinPax") int MinPax,
			@RequestParam("MaxPax") int MaxPax, @RequestParam("SignupCount") int SignupCount,
			@RequestParam("Status") String Status) {
		return service.createEvent(OrganiserID, EventName, EventDescription, StartTime, EndTime, MinPax, MaxPax, SignupCount, Status);
	}
	
	@GetMapping("/events/{id}")
	@ResponseBody
	public Map<String, String> viewEvent(@PathVariable("id") int id){
		return service.viewEvent(id);		
	}
	
	@GetMapping("/events")
	@ResponseBody
	public List<Map<String, String>> viewEvents(){
		return service.viewEvents();		
	}
	
	@DeleteMapping("/events/{id}")
	@ResponseBody
	public Map<String, String> deleteEvent(@PathVariable("id") int id){
		return service.deleteEvent(id);		
	}
	
	@PatchMapping("/events/{id}")
	@ResponseBody
	public Map<String, String> updateEvent (@PathVariable("id") int eventID, @RequestParam("OrganiserID") String OrganiserID, @RequestParam("EventName") String EventName,
			@RequestParam("EventDescription") String EventDescription, @RequestParam("StartTime") String StartTime,
			@RequestParam("EndTime") String EndTime, @RequestParam(value="MinPax", required=false) int MinPax,
			@RequestParam(value="MaxPax", required=false) int MaxPax, @RequestParam("SignupCount") int SignupCount,
			@RequestParam("Status") String Status) {
		
		return service.updateEvent(eventID, OrganiserID, EventName, EventDescription, StartTime, EndTime, MinPax, MaxPax, SignupCount, Status);
		
	}
	
}
