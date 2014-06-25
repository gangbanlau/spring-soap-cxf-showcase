package com.maingel.soap.server;

import javax.xml.ws.Endpoint;

import com.maingel.soap.web.impl.HelloWorldImpl;

public class Server {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/soap/helloWorld", new HelloWorldImpl());
	}
}
