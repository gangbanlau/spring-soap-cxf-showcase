package com.maingel.soap.service.impl;

import javax.jws.WebService;

import com.maingel.soap.service.IHelloWorld;

@WebService(endpointInterface = "com.maingel.soap.service.IHelloWorld", serviceName = "helloWorld")
public class HelloWorldImpl implements IHelloWorld {
	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}
}