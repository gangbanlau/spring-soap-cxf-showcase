package com.maingel.soap.web;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BookVOList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private List<BookVO> list;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<BookVO> getList() {
		return list;
	}
	public void setList(List<BookVO> list) {
		this.list = list;
	}
	

}
