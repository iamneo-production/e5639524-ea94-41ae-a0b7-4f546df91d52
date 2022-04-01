package com.artsandcrafts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artsandcrafts.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

	Review findByReviewId(int reviewId);
	
	Review findReviewByEnrolledCourse_EnrolledCourseId(int enrolledCourseId);

	Boolean existsReviewByEnrolledCourse_EnrolledCourseId(int enrolledCourseId);

}
