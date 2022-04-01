package com.artsandcrafts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.AcademyRepo;
import com.artsandcrafts.dao.CourseRepo;
import com.artsandcrafts.dao.EnrolledCourseRepo;
import com.artsandcrafts.dao.ReviewRepo;
import com.artsandcrafts.model.Academy;
import com.artsandcrafts.model.Course;
import com.artsandcrafts.model.EnrolledCourse;
import com.artsandcrafts.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepo reviewRepo;
	@Autowired
	EnrolledCourseRepo enrolledCourseRepo;
	@Autowired
	AcademyRepo academyRepo;
	@Autowired
	CourseRepo courseRepo;
	
	@Override
	public Review addReview(Review review) {
		EnrolledCourse eCourse = enrolledCourseRepo.findByEnrolledCourseId(review.getEnrolledCourse().getEnrolledCourseId());
		review.setEnrolledCourse(eCourse);
		Academy academy = academyRepo.findByAcademyId(review.getEnrolledCourse().getCourse().getAcademy().getAcademyId());
		double avg = (academy.getRating() + review.getRating())/2;
		academy.setRating(avg);
		academyRepo.save(academy);
		Course course = courseRepo.findByCourseId(review.getEnrolledCourse().getCourse().getCourseId());
		double courseAvg = (course.getRating() + review.getRating())/2;
		course.setRating(courseAvg);
		courseRepo.save(course);
		return reviewRepo.save(review);
	}

	@Override
	public Review viewReview(int enrolledCourseId) {
		return reviewRepo.findReviewByEnrolledCourse_EnrolledCourseId(enrolledCourseId);
	}

	@Override
	public Review editReview(int reviewId, Review review) {
		Review review2 = reviewRepo.findByReviewId(reviewId);
		review2.setRating(review.getRating());
		EnrolledCourse eCourse = enrolledCourseRepo.findByEnrolledCourseId(review.getEnrolledCourse().getEnrolledCourseId());
		review.setEnrolledCourse(eCourse);
		Academy academy = academyRepo.findByAcademyId(review.getEnrolledCourse().getCourse().getAcademy().getAcademyId());
		double avg;
		if(academy.getRating() == 0) {
			avg = review.getRating();
		}else {
			avg = (academy.getRating() + review.getRating())/2;
		}
		academy.setRating(avg);
		academyRepo.save(academy);
		Course course = courseRepo.findByCourseId(review.getEnrolledCourse().getCourse().getCourseId());
		double courseAvg;
		if(course.getRating() == 0) {
			courseAvg = review.getRating();
		}else {
			courseAvg = (course.getRating() + review.getRating())/2;
		}
		course.setRating(courseAvg);
		courseRepo.save(course);
		return reviewRepo.save(review2);
	}

	@Override
	public Boolean checkReview(int enrolledCourseId) {
		return reviewRepo.existsReviewByEnrolledCourse_EnrolledCourseId(enrolledCourseId);
	}

}
