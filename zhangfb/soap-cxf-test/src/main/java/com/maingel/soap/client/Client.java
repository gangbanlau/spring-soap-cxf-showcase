package com.maingel.soap.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maingel.soap.web.IHelloWorld;

public final class Client {
    private Client() {
    }

    public static void main(String args[]) throws Exception {
    	ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
    	IHelloWorld service = (IHelloWorld)context.getBean("helloClient");
    	String res = service.sayHi("World");
    	System.out.println(res);
    }

}
