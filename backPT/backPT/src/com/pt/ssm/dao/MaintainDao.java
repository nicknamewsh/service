package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

public interface MaintainDao {

	
	List<Map<String, Object>> getMaintainList(Map<String, Object> paramMap) throws Exception;
	long getMaintainListCount(Map<String, Object> paramMap) throws Exception;
	Map<String, Object> getMaintainId(Map<String, Object> paramMap) throws Exception;
	/**
	 * 修改信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Integer upMaintain(Map<String, Object> paramMap) throws Exception;
	
	Map<String, Object> getUsername(Map<String, Object> paramMap);
}
