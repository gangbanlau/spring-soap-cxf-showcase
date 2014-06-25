package com.maingel.soap.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(name = "User")*/
@XmlRootElement(name = "User")
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private int gender;
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
