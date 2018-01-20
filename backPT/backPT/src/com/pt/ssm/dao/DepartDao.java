package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.Depart;
import com.pt.ssm.po.Role;



public interface DepartDao {

	List<Map<String, Object>> getDepartList(Map<String, Object> paramMap);

	long getDepartListCount(Map<String, Object> paramMap);

	Map<String, Object> getDeptInfoById(Integer departId);

	Integer updateDept(Map<String, Object> paramMap);

	Integer addDept(Map<String, Object> paramMap);

	List<Map<String, Object>> getDpidInDeptId(Integer deptId);

	Integer deteleDept(Integer deptId);

	List<Depart> getAllDept();

	List<Role> getRoleList();

	List<Map<String, Object>> getPidsById(Integer deptId);

	List<Depart> getDeptList();

	List<Map<String, Object>> getDepartListBy37();







}
