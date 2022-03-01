package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.artsandcrafts.model.User;
import com.artsandcrafts.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody User user) {
	    return userservice.saveUser(user);
	}
	
	@GetMapping("/login")
	public List<User> isUserPresent(@RequestParam("email") String email, @RequestParam("password") String password) {
	    return userservice.isUserPresent(email, password);
	}
	
}
