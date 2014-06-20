package com.dp.demo.web.impl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.dp.demo.domain.Book;
import com.dp.demo.service.IBookService;
import com.dp.demo.service.impl.BookServiceImpl;
import com.dp.demo.web.BookShelfService;


@WebService(endpointInterface = "com.dp.demo.web.BookShelfService",
        serviceName="bookShelfService")
@Component(value="bookwebserviceImpl")  
public class BookShelfServiceImpl implements BookShelfService  {
  
	@Autowired
	private IBookService bookservice;
	
    public String insertBook(BookVO bookVO) {
    	Book b=new Book();
    	b.setAuthor(bookVO.getAuthor());
    	b.setBookName(bookVO.getBookName());
       this.bookservice.insertBook(b);
        //this.bookservice.insertBook(bookVO);
        return "Book with name : " +b.getBookName() + " is now available on the shelf;";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public BookVO getBook(String title) {
    	Book b=this.bookservice.queryBook(title);
    	BookVO bo=new BookVO();
    	bo.setAuthor(b.getAuthor());
    	bo.setBookName(b.getBookName());
    	bo.setBookId(b.getBookId());
        return bo ;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
