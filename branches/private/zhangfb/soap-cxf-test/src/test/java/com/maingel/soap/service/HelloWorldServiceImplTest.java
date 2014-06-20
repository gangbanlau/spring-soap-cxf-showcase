package com.maingel.soap.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.maingel.soap.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:root-context.xml", "classpath*:cxf-servlet.xml"})
@TransactionConfiguration
@Transactional
public class HelloWorldServiceImplTest {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldServiceImplTest.class);
	
	@Autowired
	private IHelloWorldService helloWorldService;
	
	@Test
	public void testSayHi() {
		logger.info("Execute testSayHi!");
		
		assertEquals("Hello World", this.helloWorldService.sayHi("World"));
	}

	@Test
	public void testFindUserById() {
		logger.info("Execute testFindUserById!");
		
		this.helloWorldService.findUserById(1);
	}

	@Test
	public void testAddUser() {
		logger.info("Execute testAddUser!");
		
		User user = new User();
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		assertEquals("SUCCESS", this.helloWorldService.addUser(user));
	}

}
