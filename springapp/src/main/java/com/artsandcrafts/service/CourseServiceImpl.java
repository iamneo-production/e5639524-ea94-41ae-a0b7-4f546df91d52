package com.artsandcrafts.service;

import com.artsandcrafts.model.Course;
import com.artsandcrafts.dao.CourseRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Override
	public Course saveAddCourse(Course course) {
		return courseRepo.save(course);
	}

    public List<Course> getAll(){
        List<Course> list =  courseRepo.findAll();
        System.out.println("List = "+list);
        return list;
    }
}
