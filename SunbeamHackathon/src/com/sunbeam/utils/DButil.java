package com.sunbeam.utils;

import java.security.Identity;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	private  static final String URL = "jdbc:mysql://localhost:3306/hackathon";
	private static final String ID = "root";
	private static final String PASSWORD = "manager";
	
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(URL,ID,PASSWORD);
		
	}

}	
