package com.maingel.soap.web.impl;

import javax.jws.WebService;

import com.maingel.soap.web.IHelloWorld;

@WebService(endpointInterface = "com.maingel.soap.web.IHelloWorld", serviceName = "helloWorld")
public class HelloWorldImpl implements IHelloWorld {
	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}
}