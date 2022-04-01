package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artsandcrafts.model.Academy;
import com.artsandcrafts.model.Course;
import com.artsandcrafts.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addNewCourse(course);
    }
	
	@GetMapping("/findByCourse/{courseName}")
    public List<Course> findByCourseName(@PathVariable String courseName) {
        return courseService.findByCourseName(courseName);
    }
	
	@GetMapping("/findCourse/{id}")
    public Course findByCourseId(@PathVariable int id) {
        return courseService.findByCourseId(id);
    }
	
	@PutMapping("/editCourse/{courseId}")
	public Course editCourse(@PathVariable int courseId, @RequestBody Course editCourse ) {
	 	return courseService.editCourse(courseId, editCourse) ;
	}
	@GetMapping("/getCourseByAcademyName/{academyId}")
	public List<Course> viewCourseByAcademyName(@PathVariable int academyId) {
		return courseService.viewCourseByAcademyId(academyId);
	}
	@GetMapping("/viewCourse")
	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}
	
	@DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

}
