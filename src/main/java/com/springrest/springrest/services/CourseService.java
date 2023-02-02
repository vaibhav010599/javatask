package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.springrest.springrest.dto.OrderRequest;
import com.springrest.springrest.dto.OrderResponse;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.entities.Faculty;
import com.springrest.springrest.entities.ImageData;

public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Optional<Courses> getCourse(Long courseId);
	
	public Courses addCourse(Courses course);
	
	

	public Courses updateCourse(Courses course);

	

	public Courses deleteCourse(Long courseId);
	
	public List<Courses> findPaginated(int pageNo,int pageSize,String sortBy);

	public ImageData setFile(ImageData img);

	public Courses saveD(OrderRequest request);

	public Iterable<Courses> findAl();

	public Iterable<OrderResponse> getJoinInformation();

	public Iterable<OrderResponse> getJoinLeftInformation();

	public Iterable<OrderResponse> getJoinRightInformation();

	
	




	
	


	
}
