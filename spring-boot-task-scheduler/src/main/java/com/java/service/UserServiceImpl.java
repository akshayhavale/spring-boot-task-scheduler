package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.User;
import com.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	/**
	 * the contract of task scheduling method is 
	 * the method should not accept any arguments and it should not return anything
	 */
	public void createUserByScheduledTime() {

	}

}
