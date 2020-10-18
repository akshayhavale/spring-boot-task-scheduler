package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.java.model.User;
import com.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final int count = 0;

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	/**
	 * the contract of task scheduling method is the method should not accept any
	 * arguments and it should not return anything
	 */
	@Scheduled(cron = "*/30 * * * * *")
	public void createUserByScheduledTime() {

		
		int counter = increment(count);
		
		User user = new User();
		user.setName("AKSHAY"+counter);

		repository.save(user);

		System.out.println(user);

	}

	public static int increment(int count) {
		return count++;
	}

}
