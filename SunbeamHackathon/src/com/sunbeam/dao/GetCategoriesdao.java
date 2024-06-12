package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunbeam.entity.Categories;
import com.sunbeam.utils.DButil;

public class GetCategoriesdao {

	
Connection connection;
	
	
	public GetCategoriesdao() throws SQLException {
		connection = DButil.getConnection();
	}
	
	
	public ArrayList<Categories> getCatDao(){
		ArrayList<Categories> list = new ArrayList<>();
		
		String sqlString = "select * from categories";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			ResultSet set = statement.executeQuery();
			
			
			while(set.next()) {
				Categories categories = new Categories();
			   categories.setId(set.getInt(1));
			   categories.setTitle(set.getString(2));
			   categories.setDescription(set.getString(3));
			   
			   list.add(categories);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	}
}
