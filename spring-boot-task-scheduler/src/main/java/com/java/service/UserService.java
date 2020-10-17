package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.model.User;

@Service
public interface UserService {
	
	public void createUserByScheduledTime();
	
	public List<User> getAllUsers();

}
