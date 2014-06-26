package com.dp.demo.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService(endpointInterface = "com.dp.demo.web.UserService",
serviceName="userService")
@Component(value="userwebserviceImpl")  
public class UserServiceImpl implements UserService {

	@Override
	@WebMethod
	public UserMapVO getusers(Map<String, String> params) {
		Map<String , UserVo> m=new HashMap<String, UserVo>();
	  	  UserVo user=new UserVo();
	  	  user.setName("user测试 1");
	  	 user.setAge(18);
	  	   m.put("user1", user);
	  	 UserVo user1=new UserVo();
	  	  user1.setName("user测试 2");
	  	 user1.setAge(22);
	  	   m.put("user2", user1);
	  	//遍历键，通过键取值
	  	Set<String> set = params.keySet();
	  	for (String key : set) {
	  	 System.out.println("键:"+key+"  值:"+params.get(key));
	  	 UserVo o=new UserVo();
	  	 o.setName(params.get(key));
	  	 m.put(key, o);
	  	}
	  	UserMapVO bm=new UserMapVO();
	  	bm.setName("测试map VO");
	  	bm.setTestresult(m);
	  	return bm;
	}

}
