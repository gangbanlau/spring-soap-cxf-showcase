package com.maingel.soap.web;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.maingel.soap.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:root-context.xml", "classpath*:cxf-servlet.xml", "classpath*:servlet-context.xml"})
@TransactionConfiguration
@Transactional
public class HelloWorldImplTest {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldImplTest.class);
	
	private static ApplicationContext context;
	private IHelloWorld helloWorld;
	
	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("client-beans.xml");
	}
	
	@AfterClass
	public static void afterClass() {
		context = null;
	}

	@Test
	public void testSayHi() {
		logger.info("Execute testSayHi!");
		
		helloWorld = (IHelloWorld)context.getBean("helloClient");
		assertEquals("Hello World", this.helloWorld.sayHi("World"));
	}

	@Test
	public void testFindUserById() {
		logger.info("Execute testFindUserById!");
		
		helloWorld = (IHelloWorld)context.getBean("helloClient");
		this.helloWorld.findUserById(1);
	}

	@Test
	public void testAddUser() {
		logger.info("Execute testAddUser!");
		
		helloWorld = (IHelloWorld)context.getBean("helloClient");
		
		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		assertEquals("SUCCESS", this.helloWorld.addUser(user));
	}

}
