package com.artsandcrafts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsandcrafts.model.EnrolledCourse;

public interface EnrolledCourseRepo extends JpaRepository<EnrolledCourse, Integer> {

	
}
