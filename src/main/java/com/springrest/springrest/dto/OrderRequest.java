package com.springrest.springrest.dto;

import com.springrest.springrest.entities.Courses;

public class OrderRequest {
	
	
	private Courses course;

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

}
