package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.sunbeam.entity.User;
import com.sunbeam.utils.DButil;

public class RegistrationDao {
	
	Connection connection;
	
	public RegistrationDao() throws SQLException {
		connection = DButil.getConnection();
	}
	
	
	public void registerUser(User u) {
		String sql = "insert into user values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, u.getId());
			statement.setString(2, u.getFull_name());
			statement.setString(3, u.getEmail());
			statement.setString(4, u.getPassword());
			statement.setString(5, u.getPhone_no());
			statement.setTimestamp(6, (Timestamp) u.getCreated_time());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
