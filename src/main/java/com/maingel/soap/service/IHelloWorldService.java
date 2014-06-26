package com.maingel.soap.service;

import java.util.List;

import com.maingel.soap.domain.User;

public interface IHelloWorldService {
	public String sayHi(String text);

	public User findUserById(long id);
	
	public List<User> findAllUser();

	public String addUser(User user);

	public String addAllUser(List<User> users);
}
