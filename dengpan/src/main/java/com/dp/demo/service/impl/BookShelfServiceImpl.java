package com.dp.demo.service.impl;

import javax.jws.WebService;

import com.dp.demo.domain.BookVO;
import com.dp.demo.service.BookShelfService;

@WebService(endpointInterface = "com.dp.demo.service.BookShelfService",
        serviceName="bookShelfService")
public class BookShelfServiceImpl implements BookShelfService {
    public String insertBook(BookVO bookVO) {
        //HashDB.insertBook(bookVO);
        return "Book with name : " + bookVO.getBookName() + " is now available on the shelf";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public BookVO getBook(String title) {
    	BookVO b=new BookVO();
    	b.setAuthor("Issac Asimov");
    	b.setBookName("Foundation and Earth");
        return b ;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
