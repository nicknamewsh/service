package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.StrataFee;

/**
 * 收取物业费
 * @author Mr.Wang
 *
 */
public interface StrataFeeDao {
	 
	List<Map<String, Object>> getStratFeeList(Map<String, Object> paramMap)throws Exception;
	
	long getTotal(Map<String, Object> paramMap)throws Exception;
	
	int addStrataFee(StrataFee strataFee)throws Exception;
	
	StrataFee getStrataFeeById(Map<String, Object> map)throws Exception;
	
	int updateStrataFee(StrataFee strataFee)throws Exception;
	
	int deleteStrataFee(long[] id)throws Exception;
	
	List<Map<String, Object>> getExportExcel(Map<String, Object> paramMap);
}
