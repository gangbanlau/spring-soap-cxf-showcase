package com.maingel.soap.web;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.maingel.soap.domain.User;

@WebService
public interface IHelloWorld {	
    public String sayHi(@WebParam(name = "text") String text);
    
    public @WebResult(name = "user") UserDTO findUserById(@WebParam(name = "id") long id);
    
    public String addUser(@WebParam(name = "user") User user);
}