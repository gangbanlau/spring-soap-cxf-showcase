package com.maingel.soap.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.maingel.soap.service.IHelloWorld;

public final class Client {
    private static final QName SERVICE_NAME 
        = new QName("http://impl.service.soap.maingel.com/", "HelloWorld");
    private static final QName PORT_NAME 
        = new QName("http://impl.service.soap.maingel.com/", "HelloWorldPort");

    private Client() {
    }

    public static void main(String args[]) throws Exception {
    	Service service = Service.create(new URL("http://localhost:8080/helloWorld?wsdl"), SERVICE_NAME);
        // Endpoint Address
        String endpointAddress = "http://localhost:8080/soap/service/helloWorld";

        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        IHelloWorld hw = service.getPort(IHelloWorld.class);
        System.out.println(hw.sayHi("World"));

    }

}
