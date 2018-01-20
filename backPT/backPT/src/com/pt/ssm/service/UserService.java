package com.pt.ssm.service;

import java.util.List;

import com.pt.ssm.po.User;
import com.pt.ssm.util.ModelBean;



public interface UserService {
	//添加用户信息
	ModelBean addUserInfo(String username,String password,String name,String departlist);
	
	//查询用户信息
	List<User> showUser() throws Exception;
	
	//删除数据
	ModelBean detUserById(String userId);
	
	//修改数据
	ModelBean updateInfoById(String username,String password,String name,Integer userId,Integer departid);
	
	//查询单个user信息
	ModelBean getUserByID(Integer userId);
	
}
