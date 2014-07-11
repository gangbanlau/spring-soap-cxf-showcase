package com.maingel.soap.web;

import java.util.List;

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

import com.maingel.soap.web.BookVO;
import com.maingel.soap.web.BookVOList;
import com.maingel.soap.web.IBookWS;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:root-context.xml",
		"classpath*:servlet-context.xml", "classpath*:datasource.xml"})
@TransactionConfiguration
@Transactional
public class BookClient {
	private static final Logger logger=LoggerFactory.getLogger(BookClient.class);
	@Test
	public void testqueryBeanList() {
		logger.info("Execute testqueryBeanList ");
        String serviceUrl = "http://localhost:8080/soap/bookquery";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IBookWS.class);
        factory.setAddress(serviceUrl);
        IBookWS bookService = (IBookWS) factory.create();
       BookVOList all=bookService.queryBeanList("123");
        for (BookVO bookVO2 : all.getList()) {
			System.out.println(bookVO2.getAuthor()+bookVO2.getBookName());
		}
      Assert.assertEquals("Thinking in java ", all.getList().get(0).getBookName());
		
	}

}
