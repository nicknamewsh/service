package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.RoleMenu;



public interface AuthorityDao {
	List<Map<String, Object>> getAuthorityList(Map<String, Object> paramMap) throws Exception;
	long getAuthorityListCount(Map<String, Object> paramMap) throws Exception;
	/**
	 * 获取树信息
	 * @param roleid (required:false)
	 * */
	List<Map<String, Object>> getMenuList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 添加ZHWY_ROLE_MENU信息
	 * @param roleId & menuid
	 * */
	Integer addrm(List<RoleMenu> list) throws Exception;
	
	/**
	 * 查询ZHWY_ROLE_MENU信息
	 * @param roleid
	 * */
	List<Map<String,Object>> getRoleMenuList(Map<String,Object> param) throws Exception;
	
	
	/**
	 * 通过roleid删除roleid_menu信息
	 * @param roleid
	 * */
	Integer delrm(long[] list) throws Exception;
	
	
	
	/**
	 * 更新ZHWY_ROLE_MENU信息
	 * 先删除再添加
	 * @param roleid & menuidList
	 * */
	Integer updaterm(List<RoleMenu> list) throws Exception;
	Integer delRmOneRole(Map<String,Object> param) throws Exception;
	
	/**
	 * 查找最大id
	 * */
	long findMaxId()throws Exception;
	
}
