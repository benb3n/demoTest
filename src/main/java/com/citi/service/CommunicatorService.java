package com.citi.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.repository.CommunicatorRepository;
import com.citi.utils.CommunicatorUtils;

@Service
public class CommunicatorService {

	@Autowired
	CommunicatorRepository repository;
	
	@Autowired
	CommunicatorUtils utils;
	
	public Map<String, String> insertNotificationSubscription(int EventID, String subject, String content) {
		repository.insertNotificationSubscription(EventID, subject, content);
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	public Map<String, String> emailSubscription(int EventID, int UserID, String subject) {
		Map<String, String> eventDetails = repository.getEventName(EventID);
		Map<String, String> userDetails = repository.getAccountName(UserID);
		Map<String, String> communicatorMapTemplate = repository.getNotificationTemplate(EventID, subject);
		String getOrganiserName = repository.getOrganiserName(eventDetails.get("OrganiserID"));
		
		String name = "";
		if (userDetails.get("Gender").equalsIgnoreCase("Male")) {
			name = "Mr. " + userDetails.get("FirstName") + " " + userDetails.get("LastName");
		}else {
			name = "Ms. " + userDetails.get("FirstName") + " " + userDetails.get("LastName");
		}
		 
		String content = communicatorMapTemplate.get("Content").replace("{name}" , name); 
		content = content.replace("{event}", eventDetails.get("Name"));
		content = content.replace("{time}", eventDetails.get("Time"));
		content = content.replace("{organiser}", getOrganiserName);
		
		utils.sendEmail(communicatorMapTemplate.get("Subject"), content, userDetails.get("Email"));
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	
	
	
}
