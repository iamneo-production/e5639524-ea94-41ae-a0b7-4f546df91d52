package com.artsandcrafts.controller;



import com.artsandcrafts.model.Course;
import com.artsandcrafts.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
	public String add(@RequestBody AddCourse addCourse) {
		addCourseService.saveAddCourse(addCourse);
		return "New Course Added";
	}

    @GetMapping("/viewCourse")
    public List<Course> list(){
        return courseService.getAll();
    }


}

