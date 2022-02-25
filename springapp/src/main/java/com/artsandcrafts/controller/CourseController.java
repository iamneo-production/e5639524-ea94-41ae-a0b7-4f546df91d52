package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.artsandcrafts.model.Course;
import com.artsandcrafts.service.AcademyService;
import com.artsandcrafts.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
	    return courseService.addCourse(course);
	}
	
	@GetMapping("/findByCourse/{courseName}")
    public List<Course> findByCourseName(@PathVariable String courseName) {
        return courseService.findByCourseName(courseName);
    }
	
	@GetMapping("/findCourse")
    public List<Course> findByCourseId(@PathVariable("id") int id) {
        return courseService.findByCourseId(id);
    }
	
	@GetMapping("/getCourseByAcademy/{courseProviderAcademy}")
    public List<Course> findByCourseProviderAcademy(@PathVariable String courseProviderAcademy) {
        return courseService.findByCourseProviderAcademy(courseProviderAcademy);
    }
	
	@RequestMapping("/viewCourse")
	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}
	
	@RequestMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

}
