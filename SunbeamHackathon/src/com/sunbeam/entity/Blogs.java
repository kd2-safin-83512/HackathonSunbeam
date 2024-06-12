package com.sunbeam.entity;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import com.sunbeam.dao.Userdao;


public class Blogs  implements Acceptable{
	
	private int id;
	private String title;
	private String contents;
	private Timestamp created_time;
	private int user_id;
	private int category_d;
	
	public Blogs() {
		super();
	}
	public Blogs(int id, String title, String contents, Timestamp date, int user_id, int category_d) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.created_time = date;
		this.user_id = user_id;
		this.category_d = category_d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getDate() {
		return created_time;
	}
	public void setDate(Timestamp date) {
		this.created_time = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCategory_d() {
		return category_d;
	}
	public void setCategory_d(int category_d) {
		this.category_d = category_d;
	}
	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", contents=" + contents + ", date=" + created_time + ", user_id="
				+ user_id + ", category_d=" + category_d + "]";
	}
	@Override
	public void acceptData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter blog id: ");
		id = scanner.nextInt();
		System.out.println("Enter title: ");
		title = scanner.next();
		System.out.println("Enter contents: ");
		contents = scanner.next();
		created_time = new Timestamp(System.currentTimeMillis());
		
		
	}

}







	

