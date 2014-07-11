package com.dp.demo.web;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookVOOutputList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private List<BookVOOutput> list;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<BookVOOutput> getList() {
		return list;
	}
	public void setList(List<BookVOOutput> list) {
		this.list = list;
	}
	

}
