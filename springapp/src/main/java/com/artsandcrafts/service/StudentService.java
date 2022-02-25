package com.artsandcrafts.service;

import java.util.List;

import com.artsandcrafts.model.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student editStudent(int studentId, Student student);

	List<Student> findByFirstName(String firstName);

	List<Student> findByStudentId(int id);

	List<Student> viewStudent();

	String deleteStudent(int id);

	Boolean existsByEmailId(String emailId);

}
