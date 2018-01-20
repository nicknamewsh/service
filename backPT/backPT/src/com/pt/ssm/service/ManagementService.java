package com.pt.ssm.service;

import java.io.UnsupportedEncodingException;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


public interface  ManagementService {
	//获取user集合
	ModelResults getUserList(String username, String name, long page, long pageSize) throws UnsupportedEncodingException;
	//获取role集合
	ModelResults getRoleList(String rolename, long page, long pageSize) throws UnsupportedEncodingException;
	//获取单个数据
	ModelBean getOneData(Integer roleid);
	//获取role全部数据
	ModelBean getRole();
	//获取depart全部数据
	ModelBean getDepart();
	//更新数据
	ModelBean updateRoleById(Integer roleid,String roleName);
	//添加数据
	ModelBean addRole(String rolename);
	//删除数据
	ModelBean delRoleById(long[] userId);
	//获取role单个信息
	ModelBean findRoleInfo(String rolename);
}
