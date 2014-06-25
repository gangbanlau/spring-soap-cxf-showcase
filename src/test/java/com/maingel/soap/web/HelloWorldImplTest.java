package com.maingel.soap.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maingel.soap.domain.User;

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
	public void testAddUser() {
		logger.info("Execute testAddUser!");
				
		User user = new User();
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		assertEquals("SUCCESS", this.helloWorld.addUser(user));
	}

}
