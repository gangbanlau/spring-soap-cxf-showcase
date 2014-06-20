package com.dp.demo.web;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dp.demo.web.impl.BookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:root-context.xml",
		"classpath*:servlet-context.xml", "classpath*:datasource.xml"})
@TransactionConfiguration
@Transactional
public class BookWebServiceTest {
	
	private final static Logger logger=LoggerFactory.getLogger(BookWebServiceTest.class);
	
	@Test
	public void testInsertBook(){
		logger.info("execute testInsertBook ");
		String serviceUrl = "http://localhost:8080/demo/wservices/bookshelfservice";

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.setServiceClass(BookShelfService.class);

        factory.setAddress(serviceUrl);

        BookShelfService bookService = (BookShelfService) factory.create();

        BookVO bookVO = new BookVO();

        bookVO.setAuthor("Issac Asimov");

        bookVO.setBookName("Foundation and Earth");

        String result = bookService.insertBook(bookVO);//返回Web service 插入结果

        System.out.println("result : " + result);
        Assert.assertEquals("Book with name : Foundation and Earth is now available on the shelf;", result);
	}
	@Test
	public void testqueryBook(){
           logger.info("execute testqueryBook");
           String serviceUrl = "http://localhost:8080/demo/wservices/bookshelfservice";
           JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
           factory.setServiceClass(BookShelfService.class);
           factory.setAddress(serviceUrl);
           BookShelfService bookService = (BookShelfService) factory.create();
           BookVO bookVO = bookService.getBook("Foundation and Earth");//返回Web service 查询结果
           Assert.assertEquals("Foundation and Earth", bookVO.getBookName());
	}
	
	
	
}
