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
		//创建WebService客户端代理工厂  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        //注册WebService接口  
        factory.setServiceClass(HelloWorld.class);  
        //设置WebService地址  
        factory.setAddress("http://localhost:8080/demo/wservices/helloworld");  
        HelloWorld greetingService = (HelloWorld)factory.create();  
        Assert.assertEquals("Hello deng pan,This is WebService world.", greetingService.sayHello("deng pan"));
		
	}

}
