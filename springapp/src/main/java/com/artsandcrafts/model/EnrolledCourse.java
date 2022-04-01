package com.artsandcrafts.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EnrolledCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrolledCourseId;
	@OneToOne
    @JoinColumn(name = "courseId")
    private Course course;
	private String joinedDate;
	private String endDate;
	
	public EnrolledCourse() {
	}
	public int getEnrolledCourseId() {
		return enrolledCourseId;
	}
	public void setEnrolledCourseId(int enrolledCourseId) {
		this.enrolledCourseId = enrolledCourseId;
	}
	public String getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}