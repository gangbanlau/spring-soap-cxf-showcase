package com.maingel.soap.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.maingel.soap.domain.User;

@WebService
public interface IHelloWorld {
	@WebMethod
    public @WebResult String sayHi(@WebParam String text);
    @WebMethod
    public @WebResult User findUserById(@WebParam long id);
    @WebMethod
    public @WebResult String addUser(@WebParam User user);
}