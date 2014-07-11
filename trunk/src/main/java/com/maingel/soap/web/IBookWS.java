package com.maingel.soap.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService
public interface IBookWS {
    @WebMethod
    public @WebResult(name = "OutputBean") BookVOList  queryBeanList (
			@WebParam(name = "InputBean") String    InputBean);

}
