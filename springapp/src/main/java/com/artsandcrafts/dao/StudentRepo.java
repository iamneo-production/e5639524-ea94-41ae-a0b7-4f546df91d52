package com.artsandcrafts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsandcrafts.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByFirstName(String firstName);

	List<Student> findByStudentId(int id);
	
	Student findById (int studentId);

	Boolean existsByEmailId(String emailId);

}
