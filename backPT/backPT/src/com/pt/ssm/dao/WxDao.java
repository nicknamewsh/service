package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.Property;
import com.pt.ssm.po.WxUser;



public interface WxDao {
	List<Map<String, Object>> wxList(Map<String, Object> paramMap) throws Exception;
	Integer wxaddbx(Map<String, Object> paramMap);
	Property mxprocess(Map<String, Object> paramMap) throws Exception;
	WxUser cfname(Map<String, Object> paramMap);

}
