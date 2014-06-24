package com.maingel.soap.web.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maingel.soap.domain.User;
import com.maingel.soap.service.IHelloWorldService;
import com.maingel.soap.web.IHelloWorld;

@WebService(endpointInterface = "com.maingel.soap.web.IHelloWorld")
//@Component(value = "helloWorldImpl")
public class HelloWorldImpl implements IHelloWorld {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldImpl.class);
	
	@Autowired
	private IHelloWorldService helloWorldService;
	
	@Override
	public String sayHi(String text) {
		logger.info("Execute sayHi!");
		
		return this.helloWorldService.sayHi(text);
	}
	
	@Override
	public User findUserById(long id) {
		logger.info("Execute findUserById!");
		
		return this.helloWorldService.findUserById(id);
	}

	@Override
	public String addUser(User user) {
		logger.info("Execute addUser!");
		
		return this.helloWorldService.addUser(user);
	}
}