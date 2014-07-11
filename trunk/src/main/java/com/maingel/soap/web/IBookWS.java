package com.maingel.soap.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.*;

@WebService
//@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public interface IBookWS {
    @WebMethod
    public @WebResult(name = "OutputBean") BookVOList  queryBeanList (
			@WebParam(name = "InputBean") String    InputBean);

}
