package com.pt.ssm.service;

import java.util.Map;

import com.pt.ssm.po.StrataFee;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface StrataFeeService {

	ModelResults getStrataFeeList(String dong,String hao,long page,long size);
	
	ModelBean addStrata(StrataFee strataFee);
	
	ModelBean getStrataFeeById(Integer id);
	
	ModelBean updateStrataFee(StrataFee strataFee);
	
	ModelBean deleteStrataFee(long[] id);
	
	ModelResults getExportExcel(Map<String, Object> paramMap);
}
