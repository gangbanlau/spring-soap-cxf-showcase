package com.dp.demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
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
    
    public List<BookVO> findall(){
    	List<BookVO> detial=new ArrayList<BookVO>();
    	BookVO b=new BookVO();
    	b.setAuthor("dp");
    	b.setBookName("测试返回list！");
    	BookVO b1=new BookVO();
    	b1.setAuthor("dp1");
    	b1.setBookName("测试返回list 1！");
    	detial.add(b);
    	detial.add(b1);
    	
    	return detial;
    	
    }
    
    public Map<String, BookVO> findmap(Map<String, String> params){
    	  Map<String , BookVO> m=new HashMap<String, BookVO>();
    	  BookVO b=new BookVO();
      	b.setAuthor("dp2");
      	b.setBookName("测试返回map！");
      	BookVO b1=new BookVO();
      	b1.setAuthor("dp3");
      	b1.setBookName("测试返回map 2！");
    	m.put("d2", b);
    	m.put("d3", b1);
    	//遍历键，通过键取值
    	Set<String> set = params.keySet();
    	for (String key : set) {
    	 System.out.println("键:"+key+"  值:"+params.get(key));
    	 BookVO bv=new BookVO();
    	 bv.setBookName(params.get(key));
    	 m.put(key, bv);//查看传入参数
    	}
    	return m;
    }

	@Override
	public BookVOOutputList queryBeanList(
			 String InputBean) {
		BookVOOutputList output=new BookVOOutputList();
		List<BookVOOutput> result=new ArrayList<BookVOOutput>();
		BookVOOutput temp=new BookVOOutput();
		temp.setAuthor("deng pan");
		temp.setBookName("Thinking in java ");
		result.add(temp);
		output.setList(result);
		output.setErrorCode("000");
		return output;
	}

    
   
}
