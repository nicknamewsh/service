package com.pt.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.StrataFeeDao;
import com.pt.ssm.po.StrataFee;
import com.pt.ssm.service.StrataFeeService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;
@Service
@Transactional
public class StrataFeeServiceImpl implements StrataFeeService{
	@Autowired
	private StrataFeeDao feeDao;
	
	@Override
	public ModelResults getStrataFeeList(String dong,String hao,long page, long size) {
		ModelResults result = new ModelResults(page, size);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("dong", dong);
		map.put("hao", hao);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = feeDao.getStratFeeList(map);
			count = feeDao.getTotal(map);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}

	@Override
	public ModelBean addStrata(StrataFee strataFee) {
		ModelBean bean = new ModelBean();
		try {
			int result = feeDao.addStrataFee(strataFee);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean getStrataFeeById(Integer id) {
		ModelBean bean = new ModelBean();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		try {
			StrataFee fee = feeDao.getStrataFeeById(map);
			bean.setObj(fee);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean updateStrataFee(StrataFee strataFee) {
		ModelBean bean = new ModelBean();
		try {
			int result = feeDao.updateStrataFee(strataFee);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean deleteStrataFee(long[] id) {
		ModelBean bean = new ModelBean();
		try {
			int result = feeDao.deleteStrataFee(id);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelResults getExportExcel(Map<String, Object> paramMap) {
		ModelResults model = new ModelResults(0, 1000);
		List<Map<String, Object>> list = feeDao.getExportExcel(paramMap);
		model.setRows(list);
		return model;
	}

	

}
