package com.citi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EventFeedbackRepository {

	public int createEventFeedback(int EventID, int UserID, String Feedback) {
		Map<String, String> result = new HashMap<>();
		
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "CitiAdmin";
			String password = "citihack2019";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username,
					password);

			Statement stmt = con.createStatement();
			status = stmt.executeUpdate(
					"Insert INTO EventFeedback(EventID, UserId, Feedback) VALUES(" + EventID + "," + UserID + ",'" + Feedback + "')");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public Map<String, String> viewEventFeedback(int eventId, int UserId){
		Map<String, String> result = new HashMap<>();
		
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "CitiAdmin";
			String password = "citihack2019";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username,
					password);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EventFeedback where EventID =" + eventId + " AND UserID=" + UserId );
			
			while (rs.next()) {
            	result.put("EventID", rs.getString(1));
            	result.put("UserID", rs.getString(2));
            	result.put("Feedback", rs.getString(3));
            }
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
		
	}
	
	public List<Map<String, String>> viewEventFeedbacks(int EventID){
		List<Map<String, String>> result = new ArrayList<>();
		
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "CitiAdmin";
			String password = "citihack2019";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username,
					password);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EventFeedback where EventID=" + EventID );
			
			while (rs.next()) {
				Map<String, String> event = new HashMap<>();
				event.put("EventID", rs.getString(1));
				event.put("UserID", rs.getString(2));
				event.put("Feedback", rs.getString(3));
            	result.add(event);
            }
			
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
}
