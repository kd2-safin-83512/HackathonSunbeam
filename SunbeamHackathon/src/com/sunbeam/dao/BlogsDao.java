package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunbeam.entity.Blogs;
import com.sunbeam.entity.Categories;
import com.sunbeam.utils.DButil;

public class BlogsDao {
	Connection connection;
	
	public BlogsDao() throws SQLException {
		connection = DButil.getConnection();
	}
	
	public void insertIntoBlog(Blogs b) {
		String sqlString = "insert into blogs values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement =connection.prepareStatement(sqlString);
			statement.setInt(1,b.getId() );
			statement.setString(2, b.getTitle());
			statement.setString(3, b.getContents());
			statement.setTimestamp(4, b.getDate());
			statement.setInt(5, b.getUser_id());
			statement.setInt(6, b.getCategory_d());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Blogs> displayAllBlogs() {
		
		String sqlString = "select * from blogs";
		
ArrayList<Blogs> list = new ArrayList<>();
		
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			ResultSet set = statement.executeQuery();
			
			
			while(set.next()) {
				Blogs blogs = new Blogs();
			   blogs.setId(set.getInt(1));
			   blogs.setTitle(set.getString(2));
			   blogs.setContents(set.getString(3));
			   blogs.setDate(set.getTimestamp(4));
			   blogs.setId(set.getInt(5));
			   blogs.setId(set.getInt(6));
			   
			   list.add(blogs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public void editBlog( int id, String content) {
		String sqlString = "update blogs set contents = ? where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			
			statement.setString(1, content);
			statement.setInt(2, id);
			
			
			statement.executeUpdate();
			System.out.println("Content updated..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Blogs> serachBlog( int id) {
		
		ArrayList<Blogs> list = new ArrayList<>();
		String sqlString = "select * from blogs where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			
			
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Blogs blogs = new Blogs();
			   blogs.setId(set.getInt(1));
			   blogs.setTitle(set.getString(2));
			   blogs.setContents(set.getString(3));
			   blogs.setDate(set.getTimestamp(4));
			   blogs.setId(set.getInt(5));
			   blogs.setId(set.getInt(6));
			   
			   list.add(blogs);
			}
			
			
			
			System.out.println("Content updated..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public void removeBlog(int id) {
		String sqlString = "delete from blogs where id = ?";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sqlString);
			statement.setInt(1, id);
		    statement.executeUpdate();
			System.out.println("deleted blog..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

}
