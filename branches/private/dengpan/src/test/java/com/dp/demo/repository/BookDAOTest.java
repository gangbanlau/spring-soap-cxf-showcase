package com.dp.demo.repository;

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

import com.dp.demo.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:root-context.xml",
		"classpath*:servlet-context.xml", "classpath*:datasource.xml"})
@TransactionConfiguration
@Transactional
public class BookDAOTest {
	
	private final static Logger logger=LoggerFactory.getLogger(BookDAOTest.class);
	@Autowired
	private IBookDAO book;
	
	@Test
	public void testInsertBook(){
		logger.info("execute testInsertBook ");
		Book b=new Book();
		b.setAuthor("dp");
		b.setBookName("十万个为什么");
		this.book.insertBook(b);
		
	}
	@Test
	public void testqueryBook(){
           logger.info("execute testqueryBook");
         this.book.queryBook("Foundation and Earth");
	}

}
