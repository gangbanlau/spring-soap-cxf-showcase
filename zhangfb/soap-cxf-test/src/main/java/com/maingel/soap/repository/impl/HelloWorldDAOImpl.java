package com.maingel.soap.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.maingel.soap.domain.User;
import com.maingel.soap.repository.IHelloWorldDAO;

@Repository
public class HelloWorldDAOImpl implements IHelloWorldDAO {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldDAOImpl.class);
	
	@Override
	public String sayHi(String text) {
		logger.info("Execute sayHi!");
		
		return "Hello " + text;
	}

	@Override
	public User findUserById(long id) {
		logger.info("Execute findUserById!");
		
		User user = new User();
		user.setId(id);
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		return user;
	}

	@Override
	public String saveUser(User user) {
		logger.info("Execute saveUser!");
		
		if(user != null){
			return "SUCCESS";
		}else{
			return "FAILURE";
		}
	}

}
