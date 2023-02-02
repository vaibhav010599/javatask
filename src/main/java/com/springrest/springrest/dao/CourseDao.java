package com.springrest.springrest.dao;
import com.springrest.springrest.dto.OrderResponse;
import com.springrest.springrest.entities.Courses;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CourseDao extends  CrudRepository<Courses, Long>{
	
	public Optional<Courses> findById(Long Id);

	public Courses getOne(Long courseId);
	
	@Query("SELECT new com.springrest.springrest.dto.OrderResponse( c.title, f.facultyName) from Courses c JOIN c.faculty f")
	public List<OrderResponse> getJoinInformation();
	
	
	@Query("SELECT new com.springrest.springrest.dto.OrderResponse( c.title, f.facultyName) from Courses c LEFT JOIN Faculty f ON c.id=f.facultyId")
	public List<OrderResponse> getJoinLeftInformation();
	
	@Query("SELECT new com.springrest.springrest.dto.OrderResponse( c.title, f.facultyName) from Faculty f RIGHT JOIN Courses c ON c.id=f.facultyId")
	public List<OrderResponse> getJoinRightInformation();
	
	

	
}
