package com.maingel.soap.server;

import javax.xml.ws.Endpoint;

import com.maingel.soap.web.BookWSImpl;
import com.maingel.soap.web.HelloWorldImpl;

public class Server {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/soap/helloWorld", new HelloWorldImpl());
		Endpoint.publish("http://localhost:8080/soap/bookquery", new BookWSImpl());
	}
}
