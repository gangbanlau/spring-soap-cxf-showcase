package com.maingel.soap.server;

import javax.xml.ws.Endpoint;

import com.maingel.soap.service.impl.HelloWorldImpl;

public class Server {
    protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/helloWorld";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
