package com.dp.demo.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.dp.demo.web.impl.BookVO;
import com.dp.demo.web.BookShelfService;

public class DemoClient {
	
	 public static void main(String[] args){

		         String serviceUrl = "http://localhost:8080/demo/wservices/bookshelfservice";

		         JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		         factory.setServiceClass(BookShelfService.class);

		         factory.setAddress(serviceUrl);

		         BookShelfService bookService = (BookShelfService) factory.create();

		         //insert book

		         BookVO bookVO = new BookVO();

		         bookVO.setAuthor("Issac Asimov");

		         bookVO.setBookName("Foundation and Earth");

		         String result = bookService.insertBook(bookVO);//返回Web service 插入结果

		         System.out.println("result : " + result);

		         bookVO = new BookVO();

		         bookVO.setAuthor("Issac Asimov");

		         bookVO.setBookName("Foundation and Empire");

		         result = bookService.insertBook(bookVO);

		         System.out.println("result : " + result);//返回Web service 插入结果

		         bookVO = new BookVO();

		         bookVO.setAuthor("Arthur C Clarke");

		         bookVO.setBookName("Rama Revealed");
              result = bookService.insertBook(bookVO);

		         System.out.println("result : " + result);//返回Web service 插入结果

		         //retrieve book

		         bookVO = bookService.getBook("Foundation and Earth");//返回Web service 查询结果

		         System.out.println("book name : " + bookVO.getBookName());

		         System.out.println("book author : " + bookVO.getAuthor());
		         System.out.println("book id : " + bookVO.getBookId());
	 }
}
