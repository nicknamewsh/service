package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.Property;

public interface WarrantyDao {

	List<Map<String, Object>> getWarrantyList(Map<String, Object> paramMap) throws Exception;
	long getWarrantyListCount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 添加信息
	 * @throws Exception
	 */
	Integer addWarranty(Map<String, Object> paramMap) throws Exception;
	/**
	 * 通过ID查询信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Property getWarrantyID(Map<String, Object> paramMap) throws Exception;
	/**
	 * 修改信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Integer upWarranty(Map<String, Object> paramMap) throws Exception;
	/**
	 * 删除信息
	 * @param list
	 * @return
	 * @throws Exception
	 */
	Integer deWarranty(Integer[] list) throws Exception;
	/**
	 * 提交信息
	 * @param list
	 * @return
	 * @throws Exception
	 */
	Integer subWarranty(Map<String, Object> paramMap) throws Exception;
}
