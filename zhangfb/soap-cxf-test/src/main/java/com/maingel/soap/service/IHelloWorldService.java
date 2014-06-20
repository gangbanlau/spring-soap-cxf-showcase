package com.maingel.soap.service;

import com.maingel.soap.domain.User;

public interface IHelloWorldService {
	public String sayHi(String text);

	public User findUserById(long id);

	public String saveUser(User user);
}
