package com.khk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
 private static Connection con;
	public static Connection getConnection() {
		
     try {
    	 //if(con==null)
    	// {
    		 Class.forName("com.mysql.jdbc.Driver");
    		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JspServletDB", "root", "");
    		 System.out.println("Connection Done!!");
    	 //}
    	 
     	} catch (ClassNotFoundException e) {
				e.printStackTrace();
     	} catch (SQLException e) {
		
     		e.printStackTrace();
     	}
	
	return con;
}
	
}
