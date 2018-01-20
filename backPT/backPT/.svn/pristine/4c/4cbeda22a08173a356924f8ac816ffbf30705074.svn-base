package com.pt.ssm.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface AssignService {

	
	//获取Property集合
	public ModelResults getAssignList(String id, String applyname, long page, long pageSize) throws UnsupportedEncodingException;
	//添加用户信息
	ModelBean addAssign(String applyname,String applycontent,String applyaddress,String applysource);
	//派发
	ModelBean payAssign(String id,String assignname,String htreason,String htstatues,String userlist);
	//报废
	ModelBean scrapAssign(String id,String assignname,String scrapwhy);
	//获取Property集合
	Map<String,Object> getAssignId(String id) throws UnsupportedEncodingException;
	
	ModelBean getuserlist(String departid);
	
}
