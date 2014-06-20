package com.dp.demo.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.dp.demo.web.HelloWorld;

public class Client {
	
	private Client() {
    }

    public static void main(String args[]) throws Exception {
 
    	 //创建WebService客户端代理工厂  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        //注册WebService接口  
        factory.setServiceClass(HelloWorld.class);  
        //设置WebService地址  
        factory.setAddress("http://localhost:8080/demo/wservices/helloworld");  
        HelloWorld greetingService = (HelloWorld)factory.create();  
        System.out.println("invoke webservice...");  
        System.out.println("message context is:"+greetingService.sayHello("deng pan"));	
    
    }

}
