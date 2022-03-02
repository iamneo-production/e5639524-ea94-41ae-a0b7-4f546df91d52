package com.artsandcrafts.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class EnrolledCourseResponse {
	
	private int studentId;
	private String firstName;
	private String phoneNumber;
	private String enrolledCourse;
	
	public EnrolledCourseResponse(int studentId, String firstName, String phoneNumber, String enrolledCourse) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.enrolledCourse = enrolledCourse;
	}
	public String getEnrolledCourse() {
		return enrolledCourse;
	}
	public void setEnrolledCourse(String enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
}
