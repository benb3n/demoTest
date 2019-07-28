package com.citi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.repository.EventFeedbackRepository;

@Service
public class EventFeedbackService {

	@Autowired
	EventFeedbackRepository repository;

	public Map<String, String> createEventFeedback(int EventID, int UserID, String Feedback) {

		repository.createEventFeedback(EventID, UserID, Feedback);

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}

	public List<Map<String, String>> viewEventFeedbacks(int EventID) {
		return repository.viewEventFeedbacks(EventID);
	}

	public Map<String, String> viewEventFeedback(int EventID, int FeedbackID) {
		return repository.viewEventFeedback(EventID, FeedbackID);
	}

}
