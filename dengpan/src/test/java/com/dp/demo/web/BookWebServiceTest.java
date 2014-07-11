package com.dp.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Test
	public void testquerylist(){
		logger.info("execute testquerylist");
        String serviceUrl = "http://localhost:8080/demo/wservices/bookshelfservice";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(BookShelfService.class);
        factory.setAddress(serviceUrl);
        BookShelfService bookService = (BookShelfService) factory.create();
        List<BookVO> all=bookService.findall();
        for (BookVO bookVO2 : all) {
			System.out.println(bookVO2.getAuthor()+bookVO2.getBookName());
		}
      Assert.assertEquals("测试返回list！", all.get(0).getBookName());
		
	}
	 
	@Test
	public void testquerymap(){
		logger.info("execute testquerymap");
        String serviceUrl = "http://localhost:8080/demo/wservices/bookshelfservice";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(BookShelfService.class);
        factory.setAddress(serviceUrl);
        BookShelfService bookService = (BookShelfService) factory.create();
        Map<String, String > params=new HashMap<String, String>();
        params.put("测试1","测试map 参数 1");
        params.put("测试2","测试map 参数 2");
        Map<String, BookVO> m=bookService.findmap(params);
        System.out.println(((BookVO)m.get("d2")).getBookName());
        System.out.println(((BookVO)m.get("d3")).getBookName());
        System.out.println(((BookVO)m.get("测试1")).getBookName());
        System.out.println(((BookVO)m.get("测试2")).getBookName());
        
      Assert.assertEquals("测试map 参数 1", ((BookVO)m.get("测试1")).getBookName());		
	}
	
	
}