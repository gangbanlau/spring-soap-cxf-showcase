package com.maingel.soap.web;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebService(endpointInterface = "com.maingel.soap.web.IBookWS")
public class BookWSImpl implements IBookWS {
	private static final Logger logger=LoggerFactory.getLogger(BookWSImpl.class);

	@Override
	public BookVOList queryBeanList( String InputBean) {
		logger.info("Execute queryBeanList ");
		BookVOList output=new BookVOList();
		List<BookVO> result=new ArrayList<BookVO>();
		BookVO temp=new BookVO();
		temp.setAuthor("deng pan");
		temp.setBookName("Thinking in java ");
		result.add(temp);
		output.setList(result);
		output.setErrorCode("000");
		return output;
	}

}
