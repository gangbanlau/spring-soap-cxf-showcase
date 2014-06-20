package com.maingel.soap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maingel.soap.domain.User;
import com.maingel.soap.repository.IHelloWorldDAO;
import com.maingel.soap.service.IHelloWorldService;

@Service
public class HelloWorldServiceImpl implements IHelloWorldService {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldServiceImpl.class);
	
	@Autowired
	private IHelloWorldDAO helloWorldDAO;
	
	@Override
	public String sayHi(String text) {
		logger.info("Execute sayHi!");
		
		return this.helloWorldDAO.sayHi(text);
	}

	@Override
	public User findUserById(long id) {
		logger.info("Execute findUserById!");
		
		return this.helloWorldDAO.findUserById(id);
	}

	@Override
	public String saveUser(User user) {
		logger.info("Execute saveUser!");
		
		return this.helloWorldDAO.saveUser(user);
	}

}
