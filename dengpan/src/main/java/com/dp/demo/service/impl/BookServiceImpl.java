package com.dp.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.demo.domain.Book;
import com.dp.demo.repository.IBookDAO;
import com.dp.demo.service.IBookService;

@Service
@Transactional
public class BookServiceImpl implements IBookService{
	private final static Logger logger=LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private IBookDAO bookdao;
	
	   @Override
	    public String insertBook(Book b){
	    	logger.info("execute insertBook");
	    	this.bookdao.deleteBook(b.getBookName());
	    	return this.bookdao.insertBook(b);
	   }
	
	  @Override
	    public Book queryBook(String bookname){
	    	logger.info("execute queryBook");
	    	return this.bookdao.queryBook(bookname);
	  }

}
