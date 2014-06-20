package com.maingel.soap.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.maingel.soap.repository.IHelloWorldDAO;

@Repository
public class HelloWorldDAOImpl implements IHelloWorldDAO {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldDAOImpl.class);
	
	@Override
	public String sayHi(String text) {
		logger.info("Execute sayHi!");
		
		return "Hello " + text;
	}

}
