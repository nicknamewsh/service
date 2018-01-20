package com.pt.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.RentDao;
import com.pt.ssm.po.Material;
import com.pt.ssm.po.Rent;
import com.pt.ssm.service.RentService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Service
@Transactional
public class RentServiceImpl implements RentService{
	
	@Autowired
	private RentDao rentDao;
	
	@Override
	public ModelResults getRentList(long page, long size, String rentName,String type,String isCome) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("rentName", rentName);
		paramMap.put("isCome", isCome);
		paramMap.put("type", type);
		paramMap.put("result", result);
		
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = rentDao.getRentList(paramMap);
			count = rentDao.getRentListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	@Override
	public ModelBean addRentInfo(Rent rent) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = rentDao.addRentInfo(rent);
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
	public ModelBean getRentInfoById(Integer id) {
		Rent m = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("id", id);
		try {
			m=rentDao.getRentInfoById(paramMap);
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
	public ModelBean updateRentInfo(Rent rent) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = rentDao.updateRentInfo(rent);
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
	public ModelBean delRentInfoByIds(long[] ids) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Integer result = rentDao.delRentInfoByIds(ids);
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
	public ModelBean updateStatueById(Integer id,String ispay,String beizhu,Double sfje) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("sfje",sfje);
		paramMap.put("ispay",ispay);
		paramMap.put("beizhu", beizhu);
		try {
			Integer result = rentDao.updateStatueById(paramMap);
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
	public ModelResults getRentList1(long page, long size, String rentName) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("rentName", rentName);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = rentDao.getRentList1(paramMap);
			count = rentDao.getRentListCount1(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	@Override
	public ModelResults getAllRentList(long page, long size, String rentName) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("rentName", rentName);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = rentDao.getAllRentList(paramMap);
			count = rentDao.getAllRentListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	
	
	@Override
	public ModelBean getrightInfoById(Integer id) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("id", id);
		List<Map<String, Object>> list = null;
		try {
			list=rentDao.getrightInfoById(paramMap);
			bean.setObj(list);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	
	}

}
