package com.maingel.soap.web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:client-beans.xml"})
public class HelloWorldImplTest {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldImplTest.class);
		
	@Autowired
	@Qualifier("helloClient")
	private IHelloWorld helloWorld;
	  
	@Test
	public void testSayHi() {
		logger.info("Execute testSayHi!");
		
		assertEquals("Hello World", this.helloWorld.sayHi("World"));
	}

	@Test
	public void testFindUserById() {
		logger.info("Execute testFindUserById!");
		
		this.helloWorld.findUserById(1);
	}
	
	@Test
	public void testFindAllUser() {
		logger.info("Execute testFindAllUser!");
		
		assertEquals("What size?", 2, this.helloWorld.findAllUser().size());
	}

	@Test
	public void testAddUser() {
		logger.info("Execute testAddUser!");
				
		UserDTO user = new UserDTO();
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		assertEquals("SUCCESS", this.helloWorld.addUser(user));
	}
	
	@Test
	public void testAddAllUser() {
		logger.info("Execute testAddAllUser!");
		
		List<UserDTO> us = new ArrayList<UserDTO>();
		UserDTO u1 = new UserDTO();
		u1.setName("zhangsan");
		u1.setGender(1);
		u1.setAge(20);
		UserDTO u2 = new UserDTO();
		u2.setName("lisi");
		u2.setGender(0);
		u2.setAge(21);
		us.add(u1);
		us.add(u2);
		assertEquals("SUCCESS", this.helloWorld.addAllUser(us));
	}

}
