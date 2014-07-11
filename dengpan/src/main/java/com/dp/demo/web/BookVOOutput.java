package com.dp.demo.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlType
public class BookVOOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String bookName;
	    private String author;
	    @XmlAttribute
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		@XmlAttribute
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
	    

}
