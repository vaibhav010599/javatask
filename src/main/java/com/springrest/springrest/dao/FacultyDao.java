package com.springrest.springrest.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Faculty;
@Repository
public interface FacultyDao extends CrudRepository<Faculty,Integer> {

}
