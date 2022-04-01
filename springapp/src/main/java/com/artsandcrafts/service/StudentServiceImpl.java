package com.artsandcrafts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.EnrolledCourseRepo;
import com.artsandcrafts.dao.StudentRepo;
import com.artsandcrafts.model.EnrolledCourse;
import com.artsandcrafts.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	@Override
	public Student editStudent(int studentId, Student student) {
		
		Student editStud = studentRepo.findById(studentId);
		List<EnrolledCourse> course = new ArrayList<EnrolledCourse>();
		course.addAll(editStud.getEnrolledCourses());

        if(Objects.nonNull(student.getAge())&&
                !"".equalsIgnoreCase(student.getAge()))
        {  editStud.setAge(student.getAge());
        }
        if(Objects.nonNull(student.getAreaName())&&
                !"".equalsIgnoreCase(student.getAreaName()))
        {  editStud.setAreaName(student.getAreaName());
        }
        if(Objects.nonNull(student.getEmailId())&&
                !"".equalsIgnoreCase(student.getEmailId()))
        {  editStud.setEmailId(student.getEmailId());
        }
        if(Objects.nonNull(student.getFatherName())&&
                !"".equalsIgnoreCase(student.getFatherName()))
        {  editStud.setFatherName(student.getFatherName());
        }
        if(Objects.nonNull(student.getGender())&&
                !"".equalsIgnoreCase(student.getGender()))
        {  editStud.setGender(student.getGender());
        }

        if(Objects.nonNull(student.getFirstName())&&
                !"".equalsIgnoreCase(student.getFirstName()))
        {  editStud.setFirstName(student.getFirstName());
        }

        if(Objects.nonNull(student.getHouseNo())&&
                !"".equalsIgnoreCase(student.getHouseNo()))
        {  editStud.setHouseNo(student.getHouseNo());
        }
        if(Objects.nonNull(student.getLastName())&&
                !"".equalsIgnoreCase(student.getLastName()))
        {  editStud.setLastName(student.getLastName());
        }

        if(Objects.nonNull(student.getMotherName())&&
                !"".equalsIgnoreCase(student.getMotherName()))
        {  editStud.setMotherName(student.getMotherName());
        }

        if(Objects.nonNull(student.getNationality())&&
                !"".equalsIgnoreCase(student.getNationality()))
        {  editStud.setNationality(student.getNationality());
        }

        if(Objects.nonNull(student.getPhoneNumber())&&
                !"".equalsIgnoreCase(student.getPhoneNumber()))
        {  editStud.setPhoneNumber(student.getPhoneNumber());
        }
        if(Objects.nonNull(student.getAlternativeNumber())&&
                !"".equalsIgnoreCase(student.getAlternativeNumber()))
        {  editStud.setAlternativeNumber(student.getAlternativeNumber());
        }
        if(Objects.nonNull(student.getPincode())&&
                !"".equalsIgnoreCase(student.getPincode()))
        {  editStud.setPincode(student.getPincode());
        }
        if(Objects.nonNull(student.getState())&&
                !"".equalsIgnoreCase(student.getState()))
        {  editStud.setState(student.getState());
        }
        if(Objects.nonNull(student.getStreetName())&&
                !"".equalsIgnoreCase(student.getStreetName()))
        {  editStud.setStreetName(student.getStreetName());
        }
        editStud.setEnrolledCourses(course);
        return studentRepo.save(editStud);
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		return studentRepo.findByFirstName(firstName);
	}

	@Override
	public List<EnrolledCourse> findByStudentId(int id) {
		Student student = studentRepo.findByStudentId(id);
		List<EnrolledCourse> eCourse = student.getEnrolledCourses();
		return eCourse;
	}

	@Override
	public List<Student> viewStudent() {
		return studentRepo.findAll();
	}

	@Override
	public String deleteStudent(int id) {
		studentRepo.deleteById(id);
		return "Deleted id " + id;
	}

	@Override
	public Boolean existsByEmailId(String emailId) {
		return studentRepo.existsByEmailId(emailId);
	}

	@Override
	public Student enrolleCourse(String emailId, Student student) {
		
		Student editStud = studentRepo.findByEmailId(emailId);
		List<EnrolledCourse> course = new ArrayList<EnrolledCourse>();
		course.addAll(student.getEnrolledCourses());
		course.addAll(editStud.getEnrolledCourses());
		editStud.setEnrolledCourses(course);
        return studentRepo.save(editStud);

	}

	@Override
	public Integer getStudentId(String email) {
		return studentRepo.getStudentId(email);
	}

	@Override
	public Boolean checkAdmission(String emailId, int courseID) {
		return studentRepo.existsByEmailIdAndEnrolledCourses_Course_CourseId(emailId, courseID);
	}

	@Override
	public Student findByStudentIDs(int id) {
		return studentRepo.findByStudentId(id);
	}
	
}
