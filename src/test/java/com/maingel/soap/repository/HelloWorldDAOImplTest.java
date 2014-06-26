package com.maingel.soap.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
@ContextConfiguration(locations={"classpath*:root-context.xml", "classpath*:cxf-context.xml"})
@TransactionConfiguration
@Transactional
public class HelloWorldDAOImplTest {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldDAOImplTest.class);
	
	@Autowired
	private IHelloWorldDAO helloWorldDAO;
	
	@Test
	public void testSayHi() {
		logger.info("Execute testSayHi!");
		
		assertEquals("Hello World", this.helloWorldDAO.sayHi("World"));
	}

	@Test
	public void testFindUserById() {
		logger.info("Execute testFindUserById!");
		
		this.helloWorldDAO.findUserById(1);
	}
	
	@Test
	public void testFindAllUser() {
		logger.info("Execute testFindAllUser!");
		
		assertEquals("What size?", 2, this.helloWorldDAO.findAllUser().size());
	}

	@Test
	public void testAddUser() {
		logger.info("Execute testAddUser!");
		
		User user = new User();
		user.setName("zhangsan");
		user.setGender(1);
		user.setAge(20);
		assertEquals("SUCCESS", this.helloWorldDAO.addUser(user));
	}
	
	@Test
	public void testAddAllUser() {
		logger.info("Execute testAddAllUser!");
		
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setName("zhangsan");
		user1.setGender(1);
		user1.setAge(20);
		User user2 = new User();
		user2.setName("lisi");
		user2.setGender(0);
		user2.setAge(21);
		users.add(user1);
		users.add(user2);		
		assertEquals("SUCCESS", this.helloWorldDAO.addAllUser(users));
	}

}
