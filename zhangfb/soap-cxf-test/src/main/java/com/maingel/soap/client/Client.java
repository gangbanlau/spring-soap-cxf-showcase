package com.maingel.soap.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maingel.soap.domain.User;
import com.maingel.soap.web.IHelloWorld;

public final class Client {
    private static ApplicationContext context;

	private Client() {
    }

    public static void main(String args[]) throws Exception {
    	context = new ClassPathXmlApplicationContext("client-beans.xml");
    	IHelloWorld service = (IHelloWorld)context.getBean("helloClient");
    	String res = service.sayHi("World");
    	System.out.println(res);
    	
    	User user = service.findUserById(1);
    	System.out.println(user.getId());
    	System.out.println(user.getName());
    	System.out.println(user.getGender());
    	System.out.println(user.getAge());
    	
    	/*User user2 = new User();
    	user2.setName("lisi");
    	user2.setGender(1);
    	user2.setAge(21);
    	String res2 = service.addUser(user2);
    	System.out.println(res2);*/
    }

}
