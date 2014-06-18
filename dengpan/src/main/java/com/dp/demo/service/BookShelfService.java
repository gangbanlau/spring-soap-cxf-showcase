package com.dp.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.dp.demo.domain.BookVO;

@WebService
public interface BookShelfService {
 
    @WebMethod
    public  String insertBook(BookVO bookVO);
    @WebMethod
    public  BookVO getBook(String title);


}
