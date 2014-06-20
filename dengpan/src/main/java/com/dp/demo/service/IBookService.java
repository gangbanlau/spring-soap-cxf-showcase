package com.dp.demo.service;

import com.dp.demo.domain.Book;

public interface IBookService {

	public String insertBook(Book b);

	public Book queryBook(String bookname);

}
