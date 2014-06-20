package com.maingel.soap.web;

import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    public String sayHi(String text);
}