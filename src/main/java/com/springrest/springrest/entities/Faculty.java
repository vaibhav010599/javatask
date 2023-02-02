package com.springrest.springrest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Faculty {
	@Id
	 private long facultyId;
		private String facultyName;
		private int facultyAge;

//		@ManyToMany(cascade = CascadeType.ALL mappedBy="faculty")
//		private Courses course;
//		
		public long getFacultyId() {
			return facultyId;
		}
		public void setFacultyId(long facultyId) {
			this.facultyId = facultyId;
		}
	
		public String getFacultyName() {
			return facultyName;
		}
		public void setFacultyName(String facultyName) {
			this.facultyName = facultyName;
		}
		public int getFacultyAge() {
			return facultyAge;
		}
		public void setFacultyAge(int facultyAge) {
			this.facultyAge = facultyAge;
		}
		
		
		

}
