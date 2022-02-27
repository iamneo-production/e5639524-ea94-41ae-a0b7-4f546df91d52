package com.artsandcrafts.controller;



import com.artsandcrafts.model.Course;
import com.artsandcrafts.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/course") //url
@CrossOrigin //security purposes
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping("/list") //url
    public List<Course> list(){
        return courseService.getAll();
    }


}

