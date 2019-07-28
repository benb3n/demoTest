package com.citi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
	

	public int createEvent(String OrganiserID, String EventName, String EventDescription,
			String startTime, String endTime, int MinPax, int MaxPax, int SignupCount, String Status) {
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
					"Insert INTO Events(OrganiserID, EventName, EventDescription, StartTime, EndTime, "
					+ "MinPax, MaxPax, SignupCount, Status) VALUES('" + OrganiserID + "','" + EventName + "','" + EventDescription + "','" +
							startTime + "','" + endTime + "'," + MinPax + "," + MaxPax + "," + SignupCount + ",'" + Status + "') ");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public Map<String, String> viewEvent(int eventId){
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
			ResultSet rs = stmt.executeQuery("select * from Events where EventID =" + eventId );
			
			while (rs.next()) {
            	result.put("EventID", rs.getString(1));
            	result.put("OrganiserID", rs.getString(2));
            	result.put("EventName", rs.getString(3));
            	result.put("EventDescription", rs.getString(4));
            	result.put("StartTime", rs.getString(5));
            	result.put("EndTime", rs.getString(6));
            	result.put("MinPax", rs.getString(7));
            	result.put("MaxPax", rs.getString(8));
            	result.put("SingleupCount", rs.getString(9));
            	result.put("Status", rs.getString(10));
            }
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
		
	}
	
	public List<Map<String, String>> viewEvents(){
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
			ResultSet rs = stmt.executeQuery("select * from Events" );
			
			while (rs.next()) {
				Map<String, String> event = new HashMap<>();
				event.put("EventID", rs.getString(1));
            	event.put("OrganiserID", rs.getString(2));
            	event.put("EventName", rs.getString(3));
            	event.put("EventDescription", rs.getString(4));
            	event.put("StartTime", rs.getString(5));
            	event.put("EndTime", rs.getString(6));
            	event.put("MinPax", rs.getString(7));
            	event.put("MaxPax", rs.getString(8));
            	event.put("SingleupCount", rs.getString(9));
            	event.put("Status", rs.getString(10));
            	result.add(event);
            }
			
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int updateEvent(int EventID, String OrganiserID, String EventName, String EventDescription,
		String startTime, String endTime, int MinPax, int MaxPax, int SignupCount, String Status) {
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "CitiAdmin";
			String password = "citihack2019";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username,
					password);

			Statement stmt = con.createStatement();
			String sql = "Update Events SET OrganiserID='" + OrganiserID + "' ,EventName= '" + EventName + 
					"' ,EventDescription= '"  + EventDescription + "' ,StartTime= '" + startTime + "' ,EndTime= '" + endTime + 
					",MinPax= " + MinPax + " ,MaxPax= " + MaxPax + " ,SignupCount= " + SignupCount + 
					"' ,Status= '" + Status + "' Where EventID= " + EventID;
//			System.out.println(sql);
			status = stmt.executeUpdate(sql);
			
	
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int deleteEvent(int eventID) {
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "CitiAdmin";
			String password = "citihack2019";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username,
					password);

			Statement stmt = con.createStatement();
			status = stmt.executeUpdate("delete from Events where EventID =" + eventID );
			
	
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
}
