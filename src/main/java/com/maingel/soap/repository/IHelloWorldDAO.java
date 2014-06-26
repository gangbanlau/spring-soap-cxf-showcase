package com.maingel.soap.repository;

import java.util.List;

import com.maingel.soap.domain.User;

public interface IHelloWorldDAO {
	public String sayHi(String text);

	public User findUserById(long id);
	
	public List<User> findAllUser();

	public String addUser(User user);

	public String addAllUser(List<User> users);

}
