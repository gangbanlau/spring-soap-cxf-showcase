package com.maingel.soap.service;

import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    String sayHi(String text);
}