package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.dao.CoursePageRepo;
import com.springrest.springrest.dao.FacultyDao;
import com.springrest.springrest.dao.ImageDao;
import com.springrest.springrest.dto.OrderRequest;
import com.springrest.springrest.dto.OrderResponse;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.entities.Faculty;
import com.springrest.springrest.entities.ImageData;
@Service
public class CourseServiceimpl implements CourseService {
	
	
	
	
	@Autowired
	private CourseDao courseDao;  //Injecting dependency
	
	@Autowired
	private CoursePageRepo coursePageRepo;
	
	@Autowired
	private ImageDao imageDao;
	
//	List<Courses> list;
	
	//constructor
	public CourseServiceimpl() { 
//		list=new ArrayList<>();
//		list.add(new Courses(155,"Java","This course contains basics of java"));
//		list.add(new Courses(122,"Spring","This course contains basics of spring"));
		
	}

	@Override
	public List<Courses> getCourses() {
		return (List<Courses>) courseDao.findAll();     //take from database and create object n add in list n provide it to the user
	}

	
	@Override
	public Optional<Courses> getCourse(Long courseId) {
		
		return courseDao.findById(courseId);
	}

	
	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Courses updateCourse(Courses course) {
		courseDao.save(course);
		return course;
		
	}

	
	@Override
	public Courses deleteCourse(Long courseId) {
		Courses entity= courseDao.getOne(courseId);
		courseDao.delete(entity);
		return null;
		
	}

	@Override
	public List<Courses> findPaginated(int pageNo, int pageSize, String sortBy) {
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Courses> pagedResult = coursePageRepo.findAll(paging);
		return pagedResult.toList();
	}

	@Override
	public ImageData setFile(ImageData img) {
		
		return imageDao.save(img);
	}

	@Override
	public Courses saveD(OrderRequest request) {
		
		return courseDao.save(request.getCourse());
	}

	@Override
	public Iterable<Courses> findAl() {
		
		return courseDao.findAll();
	}

	@Override
	public List<OrderResponse> getJoinInformation() {
		
		return courseDao.getJoinInformation();
	}

	@Override
	public Iterable<OrderResponse> getJoinLeftInformation() {
		
		return courseDao.getJoinLeftInformation();
	}

	@Override
	public Iterable<OrderResponse> getJoinRightInformation() {
	
		return courseDao.getJoinRightInformation();
	}

	
	


	
	
	
	
	
	


	
	
	
	

	

	
}
