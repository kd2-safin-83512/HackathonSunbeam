package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.sunbeam.entity.Categories;
import com.sunbeam.entity.User;
import com.sunbeam.utils.DButil;

public class CategoryDao {
	Connection connection;
	
	
	public CategoryDao() throws SQLException {
		connection = DButil.getConnection();
	}
	
	
	public void createCategory(Categories c) {
		String sql = "insert into categories values(?,?,?) ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, c.getId());
			statement.setString(2, c.getTitle());
			statement.setString(3, c.getDescription());
			
			statement.executeUpdate();
			System.out.println("Added categorie");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}

	
	
	

}
