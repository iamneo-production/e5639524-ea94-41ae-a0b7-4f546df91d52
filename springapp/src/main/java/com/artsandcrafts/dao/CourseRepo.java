package com.artsandcrafts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artsandcrafts.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	List<Course> findByCourseName(String courseName);

	List<Course> findByCourseId(int courseId);

	List<Course> findByCourseProviderAcademy(String courseProviderAcademy);

}
