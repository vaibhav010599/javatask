package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.ImageData;

public interface ImageDao extends JpaRepository<ImageData, Integer> {

}
