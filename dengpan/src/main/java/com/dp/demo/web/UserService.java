package com.dp.demo.web;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface UserService {
	@WebMethod
	public UserMapVO getusers(Map<String, String> params);

}
