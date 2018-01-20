package com.pt.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.CustomerDao;
import com.pt.ssm.dao.MaterialDao;
import com.pt.ssm.po.CustomerData;
import com.pt.ssm.po.CustomerRight;
import com.pt.ssm.po.Material;
import com.pt.ssm.service.CustomerService;
import com.pt.ssm.service.MaterialService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao cusDao;
	
	
	@Override
	public ModelResults getCustomerList(long page, long size,
			String customerName, String danWei, String post) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("customerName", customerName);
		paramMap.put("danWei", danWei);
		paramMap.put("post", post);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = cusDao.getCustomerList(paramMap);
			count = cusDao.getCustomerListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	@Override
	public ModelBean addCustomerInfo(CustomerData cus) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = cusDao.addCustomerInfo(cus);
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
	public ModelBean getCustomerInfoById(Integer id) {
		CustomerData m = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("id", id);
		try {
			m=cusDao.getCustomerInfoById(paramMap);
			bean.setObj(m);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
		}
		return bean;
	}
	@Override
	public ModelBean updateCustomerInfo(CustomerData cus) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = cusDao.updateCustomerInfo(cus);
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
	public ModelBean delCustomerInfoByIds(long[] ids) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Integer result = cusDao.delCustomerInfoByIds(ids);
			resultMap.put("result", result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			bean.setObj(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	@Override
	public ModelResults getCustomerList1(long page, long size, String huXing,
			String louYu, String beginTime, String endTime) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("huXing", huXing);
		paramMap.put("louYu", louYu);
		paramMap.put("beginTime", beginTime);
		paramMap.put("endTime", endTime);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = cusDao.getCustomerList1(paramMap);
			count = cusDao.getCustomerListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	@Override
	public ModelBean addCustomer(Map<String, Object> paramMap) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = cusDao.addCustomer(paramMap);
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
	public ModelBean updateCustomerInfo1(Map<String, Object> paramMap) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = cusDao.updateCustomerInfo1(paramMap);
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
	public ModelBean getCustomerInfoByLouHao(String loudong) {
		ArrayList<CustomerData> m = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("loudong", loudong);
		try {
			m=cusDao.getCustomerInfoByLouHao(paramMap);
			bean.setObj(m);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
		}
		return bean;
	}
	@Override
	public ModelResults getExportExcel(Map<String, Object> paramMap) {
		ModelResults result = new ModelResults(0, 1000);
		List<Map<String, Object>> list=cusDao.getExportExcel(paramMap);
		result.setRows(list);
		return result;
	}
	@Override
	public ModelBean addCustomerRight(CustomerRight right) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = cusDao.addCustomerRight(right);
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
	public ModelBean getCustomerRightById(Integer customerDataId) {
		ArrayList<CustomerData> m = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("customerDataId", customerDataId);
		try {
			m=cusDao.getCustomerRightById(paramMap);
			bean.setObj(m);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
		}
		return bean;
	}

}
