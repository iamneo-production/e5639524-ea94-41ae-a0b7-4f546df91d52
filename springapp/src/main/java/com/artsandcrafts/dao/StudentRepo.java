package com.artsandcrafts.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artsandcrafts.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByFirstName(String firstName);

	Student findByStudentId(int id);
	
	Student findById (int studentId);
	
	Student findByEmailId (String studentId);

	Boolean existsByEmailId(String emailId);

	@Query("SELECT s.studentId FROM Student s WHERE s.emailId = ?1")
	Integer getStudentId(String email);

	Boolean existsByEmailIdAndEnrolledCourses_Course_CourseId(String emailId, int courseID);

}
