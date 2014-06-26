package com.dp.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
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
public class UserServiceTest {
private final static Logger logger=LoggerFactory.getLogger(UserServiceTest.class);
	
	@Test
	public void testquerymap(){
		logger.info("execute testquerymap ");
		String serviceUrl = "http://localhost:8080/demo/wservices/userservice";

	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

	    factory.setServiceClass(UserService.class);

	    factory.setAddress(serviceUrl);

	   UserService userService = (UserService) factory.create();
	    System.out.println("========map VO 测试========");
	    Map<String, String > a=new HashMap<String, String>();
	   a.put("测试1","测试map VO 参数 1");
	   a.put("测试2","测试map VO 参数 2");
	   UserMapVO bmv=userService.getusers(a);
	   System.out.println(bmv.getName());
	   Map<String, UserVo> mapresult=bmv.getTestresult();
	    System.out.println(((UserVo)mapresult.get("user1")).getName());
	    System.out.println(((UserVo)mapresult.get("user2")).getName());
	    System.out.println(((UserVo)mapresult.get("测试1")).getName());
	    System.out.println(((UserVo)mapresult.get("测试2")).getName());
	    
		
	}

}
