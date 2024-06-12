package com.sunbeam.entity;

import java.util.Scanner;

public class Categories implements Acceptable {
	
	private int id;
	private String title;
	private String description;
	public Categories() {
		super();
	}
	public Categories(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	@Override
	public void acceptData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter title: ");
		title = scanner.next();
		System.out.println("Enter description: ");
		description = scanner.next();
		
	}
	

	

}
