package com.maingel.soap.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<User> findAllUser() {
		logger.info("Execute findAllUser!");
		
		return this.helloWorldDAO.findAllUser();
	}

	@Override
	@Transactional
	public String addUser(User user) {
		logger.info("Execute addUser!");
		
		return this.helloWorldDAO.addUser(user);
	}

	@Override
	public String addAllUser(List<User> users) {
		logger.info("Execute addAllUser!");
		
		return this.helloWorldDAO.addAllUser(users);
	}

}
