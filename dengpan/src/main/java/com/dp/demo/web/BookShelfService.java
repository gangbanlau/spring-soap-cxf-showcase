package com.dp.demo.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.dp.demo.domain.Book;
import com.dp.demo.web.impl.BookVO;

@WebService
public interface BookShelfService {
 
    @WebMethod
    public  String insertBook( BookVO bookVO);
    @WebMethod
    public  BookVO getBook( String title);


}
