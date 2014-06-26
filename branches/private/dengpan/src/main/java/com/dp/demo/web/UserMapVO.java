package com.dp.demo.web;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "USERMap")
public class UserMapVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, UserVo> testresult;
	
	private String name;

 
	public Map<String, UserVo> getTestresult() {
		return testresult;
	}

	public void setTestresult(Map<String, UserVo> testresult) {
		this.testresult = testresult;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
