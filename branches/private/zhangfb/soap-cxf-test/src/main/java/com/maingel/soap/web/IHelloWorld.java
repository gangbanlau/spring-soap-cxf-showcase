package com.maingel.soap.web;

import javax.jws.WebService;

import com.maingel.soap.domain.User;

@WebService
public interface IHelloWorld {
    public String sayHi(String text);
    
    public User findUserById(long id);
    
    public String addUser(User user);
}