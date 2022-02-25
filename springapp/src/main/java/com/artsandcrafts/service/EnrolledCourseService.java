package com.artsandcrafts.service;

import java.util.List;

import com.artsandcrafts.model.EnrolledCourse;

public interface EnrolledCourseService {

	EnrolledCourse addAdmission(EnrolledCourse student);

	List<EnrolledCourse> viewAdmission();

}
