package com.maingel.soap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
