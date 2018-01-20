package com.pt.ssm.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.WxDao;
import com.pt.ssm.po.Property;
import com.pt.ssm.po.WxUser;
import com.pt.ssm.service.WxService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Service
@Transactional
public class WxServiceImpl implements WxService{

	@Autowired
	private WxDao wxDao;
	
	@Override
	public ModelResults wxList(Map<String, Object> paramMap) {
		ModelResults result = new ModelResults(0, 100);
		List<Map<String, Object>> wxlist = null;
		try {
			 wxlist = wxDao.wxList(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		result.setRows(wxlist);
		return result;
	}

	@Override
	public ModelBean wxaddbx(Map<String, Object> paramMap) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = wxDao.wxaddbx(paramMap);
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
	public ModelBean mxprocess(String id) {
		ModelBean bean = new ModelBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//根据ID查询用户信息
			Property property=wxDao.mxprocess(map);
			resultMap.put("property", property);
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
	public ModelBean cfname(Map<String, Object> paramMap) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//根据ID查询用户信息
			WxUser wxuser=wxDao.cfname(paramMap);
			resultMap.put("wxuser", wxuser);
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
	
	
	
	
	
	

}

