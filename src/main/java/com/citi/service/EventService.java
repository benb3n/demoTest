package com.citi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository repository;
	
	public Map<String, String> createEvent(String OrganiserID, String EventName, String EventDescription, 
			String StartTime, String EndTime, int MinPax, int MaxPax, int SignupCount, String Status){
		String startDate;
		String endDate;
		Date currentDate;
		try {
			currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(StartTime);
			startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
			
			currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(EndTime);
			endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
		
			repository.createEvent(OrganiserID, EventName, EventDescription, startDate, endDate, MinPax, MaxPax, SignupCount, Status);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	public Map<String, String> viewEvent(int eventId){
		return repository.viewEvent(eventId);
	}
	
	
	public List<Map<String, String>> viewEvents(){
		return repository.viewEvents();
	}
	
	public Map<String, String> updateEvent(int EventID, String OrganiserID, String EventName, String EventDescription, 
			String StartTime, String EndTime, int MinPax, int MaxPax, int SignupCount, String Status){
		
		Date currentDate;
		String startDate;
		String endDate;
		
		try {
			currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(StartTime);
			startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
			
			currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(EndTime);
			endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
		
		
			repository.updateEvent(EventID, OrganiserID, EventName, EventDescription, startDate, endDate, MinPax, MaxPax, SignupCount, Status);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	public Map<String, String> deleteEvent(int eventId){
		repository.deleteEvent(eventId);
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
}
