package com.maingel.soap.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
	@WebMethod
    public String sayHi(@WebParam(name = "text") String text);
    @WebMethod
    public UserDTO findUserById(@WebParam(name = "id") long id);
    @WebMethod
    public List<UserDTO> findAllUser();
    @WebMethod
    public String addUser(@WebParam(name = "user") UserDTO user);
    @WebMethod
    public String addAllUser(List<UserDTO> us);
}