package com.artsandcrafts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artsandcrafts.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
	List<User> findByEmailAndPassword (String email, String password);

}
