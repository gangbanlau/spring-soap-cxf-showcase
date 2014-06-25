package com.maingel.soap.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
	@WebMethod
    public String sayHi(@WebParam(name = "text") String text);
    @WebMethod
    public @WebResult(name = "user") UserDTO findUserById(@WebParam(name = "id") long id);
    @WebMethod
    public String addUser(@WebParam(name = "user") UserDTO user);
}