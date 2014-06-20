package com.maingel.soap.web;

import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    String sayHi(String text);
}