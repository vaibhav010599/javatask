package com.springrest.springrest.dao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Courses;
@Repository
public interface CoursePageRepo extends PagingAndSortingRepository<Courses,Long>{

}
