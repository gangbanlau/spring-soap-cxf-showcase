package com.maingel.soap.web.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maingel.soap.domain.User;
import com.maingel.soap.service.IHelloWorldService;
import com.maingel.soap.web.IHelloWorld;
import com.maingel.soap.web.UserDTO;

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
	public UserDTO findUserById(long id) {
		logger.info("Execute findUserById!");
		
		User u = this.helloWorldService.findUserById(id);
		UserDTO user = new UserDTO();
		user.setId(u.getId());
		user.setName(u.getName());
		user.setGender(u.getGender());
		user.setAge(u.getAge());
		return user;
	}

	@Override
	public List<UserDTO> findAllUser() {
		logger.info("Execute findAllUser!");
		
		List<User> us = this.helloWorldService.findAllUser();
		List<UserDTO> users = new ArrayList<UserDTO>();
		for(User u : us){
			UserDTO user = new UserDTO();
			user.setId(u.getId());
			user.setName(u.getName());
			user.setGender(u.getGender());
			user.setAge(u.getAge());
			users.add(user);
		}
		return users;
	}
	
	@Override
	public String addUser(UserDTO user) {
		logger.info("Execute addUser!");
		
		User u = new User();
		user.setId(user.getId());
		user.setName(user.getName());
		user.setGender(user.getGender());
		user.setAge(user.getAge());
		
		return this.helloWorldService.addUser(u);
	}

	@Override
	public String addAllUser(List<UserDTO> us) {
		logger.info("Execute addAllUser!");
		
		List<User> users = new ArrayList<User>();
		for(UserDTO u : us){
			User user = new User();
			user.setId(u.getId());
			user.setName(u.getName());
			user.setGender(u.getGender());
			user.setAge(u.getAge());
			users.add(user);
		}
		return this.helloWorldService.addAllUser(users);
	}
}