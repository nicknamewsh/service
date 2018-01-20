package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

public interface ManagementDao {
	List<Map<String, Object>> getUserList(Map<String, Object> paramMap) throws Exception;
	long getUserListCount(Map<String, Object> paramMap) throws Exception;
	
	List<Map<String, Object>> getRoleList(Map<String, Object> paramMap) throws Exception;
	
	long getRoleListCount(Map<String, Object> paramMap) throws Exception;
	
	Map<String, Object> getOneData(Integer roleid);
	
	List<Map<String, Object>> getRole();
	
	List<Map<String, Object>> getDepart();
	
	Integer updateRole(Map<String, Object> paramMap);
	
	Integer addRole(Map<String, Object> paramMap);
	
	Integer delRole(long[] list);
	
	Map<String, Object> getOneRole(Map<String, Object> paramMap) throws Exception; 
}
