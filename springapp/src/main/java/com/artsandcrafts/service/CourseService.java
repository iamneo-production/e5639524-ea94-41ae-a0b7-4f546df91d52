package com.artsandcrafts.service;

import java.util.List;

import com.artsandcrafts.model.Course;

public interface CourseService {

	public Course addCourse(Course course);

	public List<Course> findByCourseName(String courseName);

	public List<Course> findByCourseId(int id);

	public List<Course> findByCourseProviderAcademy(String courseProviderAcademy);

	public List<Course> getAllCourse();

	public String deleteCourse(int id);

}
