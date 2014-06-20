package com.dp.demo.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.dp.demo.domain.Book;
import com.dp.demo.repository.IBookDAO;
@Repository
public class BookDAOImpl implements IBookDAO{
         
private static final Logger logger=LoggerFactory.getLogger(BookDAOImpl.class);
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    @Override
    public String insertBook(Book b){
    	logger.info("execute insertBook");
    	String sql="INSERT  INTO book(book_name,author) VALUES(?,?) ";
    	this.jdbcTemplate.update(sql, new Object[]{b.getBookName(),b.getAuthor()});
    	return "success";
    	
    }
    @Override
    public void deleteBook(String bookname){
    	logger.info("execute deleteBook");
    	String sql="DELETE FROM book WHERE book_name=?";
    	this.jdbcTemplate.update(sql, new Object[]{bookname});
   	
    }
    @Override
    public Book queryBook(String bookname){
    	logger.info("execute queryBook");
    	List<Book> details=new ArrayList<Book>();
    	String sql="SELECT book_id,book_name,author FROM book WHERE book_name=? ";
    	details=this.jdbcTemplate.query(sql, new Object[]{bookname}, new ParameterizedRowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int i) throws SQLException {
				Book b=new Book();
				b.setBookId(rs.getLong("book_id"));
				b.setBookName(rs.getString("book_name"));
				b.setAuthor(rs.getString("author"));
				return b;
			}
		});
    	return details.size()>=1?details.get(0):null;
    	
    }
    
}
