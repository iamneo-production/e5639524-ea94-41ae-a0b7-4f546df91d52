package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artsandcrafts.model.Review;
import com.artsandcrafts.service.ReviewService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/addReview")
	public Review addReview(@RequestBody Review review) {
	    return reviewService.addReview(review);
	}
	
	@PutMapping("/editReview/{reviewId}")
	public Review editReview(@PathVariable int reviewId, @RequestBody Review review) {
	    return reviewService.editReview(reviewId, review);
	}
	
	@GetMapping("/viewReview/{enrolledCourseId}")
	public Review viewReview(@PathVariable int enrolledCourseId) {
		return reviewService.viewReview(enrolledCourseId);
	}
	
	@GetMapping("/checkReview/{enrolledCourseId}")
	public Boolean checkReview(@PathVariable int enrolledCourseId) {
	    Boolean bool =  reviewService.checkReview(enrolledCourseId);
	    if(bool) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
}
