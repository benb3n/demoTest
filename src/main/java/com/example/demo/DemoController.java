package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class DemoController {
	
	@RequestMapping("/index")
    String index() {
        
		
		 System.out.println("starting");
	        // try {
	        //     Class.forName("com.mysql.jdbc.Driver");
	        //     String username ="ben";
	        //     String password = "password";
	        //     Connection con = DriverManager.getConnection("jdbc:mysql://165.22.59.122:3306/TestingDB", username, password);
	 
	        //     Statement stmt = con.createStatement();
	        //     ResultSet rs = stmt.executeQuery("select * from firstTable");
	        //     System.out.println("Pulled data");
	            
	        //     while (rs.next()) {
	        //         return rs.getString(1) + "  " + rs.getString(2) ;
	        //     }
	        //     con.close();
	        // } catch (Exception e) {
	        //     System.out.println(e);
	        // }
	        
		
        return "Well Done!! Nice Try!! Good bye!";
    }
	
}
