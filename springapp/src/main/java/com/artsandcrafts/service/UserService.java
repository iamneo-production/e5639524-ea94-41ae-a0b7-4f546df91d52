package com.artsandcrafts.service;

import java.util.List;

import com.artsandcrafts.model.User;

public interface UserService  {

	public User saveUser(User user);

	public List<User> isUserPresent(String email, String password);

}
