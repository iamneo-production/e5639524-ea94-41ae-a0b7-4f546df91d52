package com.artsandcrafts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private double rating;
	@OneToOne
	@JoinColumn(name = "enrolledCourseId")
	private EnrolledCourse enrolledCourse;
	
	public EnrolledCourse getEnrolledCourse() {
		return enrolledCourse;
	}
	public void setEnrolledCourse(EnrolledCourse enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}
	public Review(int reviewId, double rating) {
		this.reviewId = reviewId;
		this.rating = rating;
	}
	public Review() {
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
