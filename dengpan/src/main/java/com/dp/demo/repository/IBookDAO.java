package com.dp.demo.repository;

import com.dp.demo.domain.Book;

public interface IBookDAO {

	public String insertBook(Book b);

	public Book queryBook(String bookname);

	public void deleteBook(String bookname);

}
