package com.dp.demo.web;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.dp.demo.domain.Book;

@WebService
public interface BookShelfService {
 
    @WebMethod
    public  String insertBook( BookVO bookVO);
    @WebMethod
    public  BookVO getBook( String title);
    @WebMethod
    public List<BookVO> findall();
    @WebMethod
    public Map<String, BookVO> findmap(Map<String, String> params);
    
    
}
