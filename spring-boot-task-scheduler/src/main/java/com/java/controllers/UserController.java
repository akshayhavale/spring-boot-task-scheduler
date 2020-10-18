package com.java.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.User;
import com.java.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		logger.info("The current thread name is"+Thread.currentThread());
		return service.getAllUsers();
	}

}
