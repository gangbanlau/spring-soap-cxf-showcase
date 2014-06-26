package com.dp.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.net.URL;

import javax.xml.ws.Endpoint;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.dp.demo.web.impl.BookShelfServiceImpl;
import com.dp.demo.web.impl.HelloWorldImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:root-context.xml",
		"classpath*:servlet-context.xml", "classpath*:datasource.xml"})
@TransactionConfiguration
@Transactional
public class HelloWordWebServiceTest {
	private final static Logger logger=LoggerFactory.getLogger(HelloWordWebServiceTest.class);
	
	
	@Test
	public void testSayHello(){
		logger.info("execute testSayHello");
		
		// Publishes the SOAP Web Service
	    Endpoint endpoint = Endpoint.publish("/wservices/helloworldss", new HelloWorldImpl());
	    Assert.assertEquals(true,endpoint.isPublished());
	    System.out.println(endpoint.getBinding().getBindingID());
	    System.out.println(endpoint.getMetadata());
	    Assert.assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());
	 
	/*	
	 // Data to access the web service
	    URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
	    String namespaceURI = "http://chapter21.javaee7.book.agoncal.org/ ";
	    String servicePart = "CardValidatorService";
	    String portName = "CardValidatorPort";
	    QName serviceQN = new QName(namespaceURI, servicePart);
	    QName portQN = new QName(namespaceURI, portName);
	 
	    // Creates a service instance
	    Service service = Service.create(wsdlDocumentLocation, serviceQN);
	    Validator cardValidator = service.getPort(portQN, Validator.class);
	 
	    // Invokes the web service
	    CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
	 
	    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
	    creditCard.setNumber("12341233");
	    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
	 
	    // Unpublishes the SOAP Web Service
	    endpoint.stop();
	    assertFalse(endpoint.isPublished());*/
	    
		//创建WebService客户端代理工厂  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        //注册WebService接口  
        factory.setServiceClass(HelloWorld.class);  
        //设置WebService地址  
        factory.setAddress("http://localhost:8080/demo/wservices/wservices/helloworldss");  
        HelloWorld greetingService = (HelloWorld)factory.create();  
        Assert.assertEquals("Hello deng pan,This is WebService world.", greetingService.sayHello("deng pan"));
        endpoint.stop();
	}

}
