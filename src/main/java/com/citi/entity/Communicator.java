package com.citi.entity;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class Communicator {
	
//	@Id
	private int EventID;
	private String Subject;
	private String Content;
	
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
