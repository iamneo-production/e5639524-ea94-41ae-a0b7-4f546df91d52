package com.artsandcrafts.service;

import java.util.List;

import com.artsandcrafts.model.Course;

public interface CourseService {
	
	public Course addNewCourse(Course course);

	public List<Course> findByCourseName(String courseName);

	public Course findByCourseId(int id);

	public List<Course> getAllCourse();

	public String deleteCourse(int id);

	public Course editCourse(int courseId, Course editCourse);

	public List<Course> viewCourseByAcademyId(int academyName);

}
