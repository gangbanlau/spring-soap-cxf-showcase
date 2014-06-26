package com.dp.demo.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.dp.demo.web.BookShelfService;
import com.dp.demo.web.BookVO;
import com.dp.demo.web.UserMapVO;
import com.dp.demo.web.UserService;
import com.dp.demo.web.UserVo;

public class UserClient {
	
public static void main(String[] args){
	String serviceUrl = "http://localhost:8080/demo/wservices/userservice";

    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    factory.setServiceClass(UserService.class);

    factory.setAddress(serviceUrl);

   UserService userService = (UserService) factory.create();
    System.out.println("========map VO 测试========");
    Map<String, String > a=new HashMap<String, String>();
   a.put("测试1","测试map VO 参数 1");
   a.put("测试2","测试map VO 参数 2");
   UserMapVO bmv=userService.getusers(a);
   System.out.println(bmv.getName());
   Map<String, UserVo> mapresult=bmv.getTestresult();
    System.out.println(((UserVo)mapresult.get("user1")).getName());
    System.out.println(((UserVo)mapresult.get("user2")).getName());
    System.out.println(((UserVo)mapresult.get("测试1")).getName());
    System.out.println(((UserVo)mapresult.get("测试2")).getName());
}
}