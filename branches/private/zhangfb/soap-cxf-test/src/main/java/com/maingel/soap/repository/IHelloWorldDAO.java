package com.maingel.soap.repository;

import com.maingel.soap.domain.User;

public interface IHelloWorldDAO {
	public String sayHi(String text);

	public User findUserById(long id);

	public String saveUser(User user);

}
