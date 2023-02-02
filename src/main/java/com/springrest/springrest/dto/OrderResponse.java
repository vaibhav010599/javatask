package com.springrest.springrest.dto;

public class OrderResponse {

	private String title;
	private String facultyName;
	
	
	public OrderResponse(String title, String facultyName) {
		super();
		this.title = title;
		this.facultyName = facultyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	
}
