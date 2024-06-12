package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.utils.DButil;

	public class Userdao implements AutoCloseable{
		private Connection connection;
		
		public Userdao () throws SQLException {
			connection = DButil.getConnection();
		}
		
		public int checkForUserCreds(Scanner sc, String email, String password) throws SQLException {
			int userID = -1 ;
			String sql = "Select * from user where email = ? and password = ?";
			try(PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					if(rs.getString(3).equals(email) && rs.getString(4).equals(password)) {
						userID = rs.getInt(1);
						System.out.println("Login Successful");
						return userID;
					}
					else {
						System.out.println("Invalid Credentials");
						return userID;
					}
				}
			}
			return userID;
		}

		@Override
		public void close() throws Exception {
			if(connection != null)
				connection.close();
			
		}
	}


