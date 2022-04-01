package com.artsandcrafts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.EnrolledCourseRepo;
import com.artsandcrafts.dao.ReviewRepo;
import com.artsandcrafts.model.Course;
import com.artsandcrafts.model.EnrolledCourse;
import com.artsandcrafts.model.Review;

@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService {
	@Autowired
	EnrolledCourseRepo enrolledCourseRepo;
	
	@Autowired
	ReviewRepo reviewRepo;

	@Override
	public EnrolledCourse addAdmission(EnrolledCourse enrolledCourse) {
		return enrolledCourseRepo.save(enrolledCourse);
	}

	@Override
	public EnrolledCourse viewAdmission(int id) {
		return enrolledCourseRepo.findByEnrolledCourseId(id);
	}

	@Override
	public String deleteAdmission(int id) {
		Review review = reviewRepo.findReviewByEnrolledCourse_EnrolledCourseId(id);
		reviewRepo.delete(review);
		enrolledCourseRepo.deleteById(id);
		return "Deleted id " + id;
	}
}
