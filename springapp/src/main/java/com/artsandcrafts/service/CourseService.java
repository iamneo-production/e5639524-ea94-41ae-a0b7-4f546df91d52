package com.artsandcrafts.service;

import com.artsandcrafts.model.Course;

import java.util.List;

public interface CourseService {
    
    public AddCourse saveAddCourse(AddCourse addCourse);
    public List<Course> getAll();
}
