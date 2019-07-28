package com.citi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository
public class CommunicatorRepository {
	
	public Map<String, String> getEventName(int eventID) {
		Map<String, String> result = new HashMap<>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String username ="CitiAdmin";
            String password = "citihack2019";
            Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select EventName, StartTime, OrganiserID from Events where EventID =" + eventID);
           
            while (rs.next()) {
            	result.put("Name", rs.getString(1));
            	result.put("Time", rs.getString(2));
            	result.put("OrganiserID", rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return result;
	}
	
	public Map<String, String> getAccountName(int UserID) {
		Map<String, String> result = new HashMap<>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String username ="CitiAdmin";
            String password = "citihack2019";
            Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select FirstName, LastName, Email, Gender from Accounts where UserID =" + UserID);
           
            while (rs.next()) {
            	result.put("FirstName", rs.getString(1));
            	result.put("LastName", rs.getString(2));
            	result.put("Email", rs.getString(3));
            	result.put("Gender", rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return result;
	}
	
	public String getOrganiserName(String OrganiserID) {
	
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String username ="CitiAdmin";
            String password = "citihack2019";
            Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select OrganiserName from Organisers where OrganiserID ='" + OrganiserID + "'");
           
            while (rs.next()) {
            	return rs.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;
	}
	
	public Map<String, String> getNotificationTemplate(int eventID, String subject) {
		Map<String, String> result = new HashMap<>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String username ="CitiAdmin";
            String password = "citihack2019";
            Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);

            Statement stmt = con.createStatement();
            String sql = "select * from EventNotificationTemplate where EventID = " + eventID + " AND Subject = '" + subject + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
           
            while (rs.next()) {
            	result.put("Subject", rs.getString(2));
            	result.put("Content", rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return result;
	}
	
	public Map<String, String> insertNotificationSubscription(int eventID, String subject, String content) {
		Map<String, String> result = new HashMap<>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String username ="CitiAdmin";
            String password = "citihack2019";
            Connection con = DriverManager.getConnection("jdbc:mysql://citihack2019.cwop36kfff9j.ap-southeast-1.rds.amazonaws.com:3306/innodb", username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Insert INTO EventNotificationTemplate(EventID, Subject, Content) VALUES (" + eventID + "," + subject + "," + content ); 
            while (rs.next()) {
            	result.put("Name", rs.getString(1));
            	result.put("Time", rs.getString(2));
            	result.put("OrganiserID", rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return result;
	}
	
}
