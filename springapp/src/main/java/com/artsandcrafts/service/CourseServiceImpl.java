package com.artsandcrafts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.CourseRepo;
import com.artsandcrafts.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepo courseRepo;

	@Override
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public List<Course> findByCourseName(String courseName) {
		return courseRepo.findByCourseName(courseName);
	}

	@Override
	public List<Course> findByCourseId(int id) {
		return courseRepo.findByCourseId(id);
	}

	@Override
	public List<Course> findByCourseProviderAcademy(String courseProviderAcademy) {
		return courseRepo.findByCourseProviderAcademy(courseProviderAcademy);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	@Override
	public String deleteCourse(int id) {
		courseRepo.deleteById(id);
		return "Deleted id "+id;
	}

}
