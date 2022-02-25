package com.artsandcrafts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.EnrolledCourseRepo;
import com.artsandcrafts.model.EnrolledCourse;


@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService {
	@Autowired
	EnrolledCourseRepo enrolledCourseRepo;

	@Override
	public EnrolledCourse addAdmission(EnrolledCourse student) {
		return enrolledCourseRepo.save(student);
	}

	@Override
	public List<EnrolledCourse> viewAdmission() {
		return enrolledCourseRepo.findAll();
	}

}
