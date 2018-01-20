package com.pt.ssm.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface MaintainService {

	
	//获取Property集合
	public ModelResults getMaintainList(String id, String applyname, long page, long pageSize) throws UnsupportedEncodingException;
	//修改数据
	ModelBean upMaintain(String id,String maintainname,String repairmoney,String materialmoney,String completecontent,String maintaindate,String archivename);
	//获取Property集合
	Map<String,Object> getMaintainId(String id) throws UnsupportedEncodingException;
	//获取维修人
	Map<String,Object> getUsername(String id) throws UnsupportedEncodingException;
}