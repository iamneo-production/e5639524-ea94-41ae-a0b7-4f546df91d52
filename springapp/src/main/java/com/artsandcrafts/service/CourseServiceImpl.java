package com.artsandcrafts.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.AcademyRepo;
import com.artsandcrafts.dao.CourseRepo;
import com.artsandcrafts.dao.EnrolledCourseRepo;
import com.artsandcrafts.model.Academy;
import com.artsandcrafts.model.Course;
import com.artsandcrafts.model.EnrolledCourse;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	AcademyRepo academyRepo;
	@Autowired
	EnrolledCourseRepo enrolledCourseRepo;
	
	@Override
	public Course addNewCourse(Course course) {
		Academy academy = academyRepo.findByAcademyName(course.getAcademy().getAcademyName());
		course.setAcademy(academy);
		return courseRepo.save(course);
	}

	@Override
	public List<Course> findByCourseName(String courseName) {
		return courseRepo.findByCourseName(courseName);
	}

	@Override
	public Course findByCourseId(int id) {
		return courseRepo.findByCourseId(id);
	}
	
	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	@Override
	public String deleteCourse(int id) {
		List<EnrolledCourse> course = enrolledCourseRepo.findByCourseCourseId(id);
		enrolledCourseRepo.deleteAll(course);
		courseRepo.deleteById(id);
		return "Deleted id "+id;
	}

	@Override
	public Course editCourse(int courseId, Course course) {
		Course editCourse = courseRepo.findByCourseId(courseId);
    	
    	if(Objects.nonNull(course.getCourseName())&&
                !"".equalsIgnoreCase(course.getCourseName()))
        {  editCourse.setCourseName(course.getCourseName());
        }
    	if(Objects.nonNull(course.getCourseDescription())&&
                !"".equalsIgnoreCase(course.getCourseDescription()))
        {  editCourse.setCourseDescription(course.getCourseDescription());
        }
    	if(Objects.nonNull(course.getCourseDuration())&&
                !"".equals(course.getCourseDuration()))
        {  editCourse.setCourseDuration(course.getCourseDuration());
        }
    	if(Objects.nonNull(course.getStartTime())&&
                !"".equalsIgnoreCase(course.getStartTime()))
        {  editCourse.setStartTime(course.getStartTime());
        }
    	if(Objects.nonNull(course.getEndTime())&&
                !"".equalsIgnoreCase(course.getEndTime()))
        {  editCourse.setEndTime(course.getEndTime());
        }
    	if(Objects.nonNull(course.getNoOfStudents())&&
                !"".equals(course.getNoOfStudents()))
        {  editCourse.setNoOfStudents(course.getNoOfStudents());
        }
    	Academy academy = academyRepo.findByAcademyName(course.getAcademy().getAcademyName());
    	editCourse.setAcademy(academy);
		return courseRepo.save(editCourse);
	}

	@Override
	public List<Course> viewCourseByAcademyId(int academyId) {
		return courseRepo.findByAcademy_AcademyId(academyId);
	}
	
}