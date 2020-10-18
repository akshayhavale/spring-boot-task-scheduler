package com.java.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.java.model.User;
import com.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
	@Scheduled(cron = "*/10 * * * * *")
	public void createUserByScheduledTime() {

		User user = new User();
		user.setName("AKSHAY" + System.currentTimeMillis());

		repository.save(user);

		logger.info("The inserted user is" + user);

	}

}
