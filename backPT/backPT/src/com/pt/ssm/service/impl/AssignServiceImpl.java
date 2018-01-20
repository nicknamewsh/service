package com.pt.ssm.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.AssignDao;
import com.pt.ssm.po.Property;
import com.pt.ssm.service.AssignService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Service
@Transactional
public class AssignServiceImpl implements AssignService{

	@Autowired
	private AssignDao assignDao;
	private List<Property> propertyList = new ArrayList<Property>();
	
	
	@Override
	public ModelResults getAssignList(String id, String applyname, long start, long end) throws UnsupportedEncodingException {
		ModelResults result = new ModelResults(start, end);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", URLDecoder.decode(id, "UTF-8"));
		paramMap.put("applyname", URLDecoder.decode(applyname, "UTF-8"));
		paramMap.put("result", result);
		
		List<Map<String, Object>> propertytList = null;
		long count = 0;
		try {
			propertytList = assignDao.getAssignList(paramMap);
			count = assignDao.getAssignListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(propertytList);
		result.setTotal(count);
		return result;
	}
	
	@Override
	public ModelBean addAssign(String applyname,String applycontent,String applyaddress,String applysource) {
		ModelBean bean = new ModelBean();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("applyname", applyname);
		paramMap.put("applycontent", applycontent);
		paramMap.put("applyaddress", applyaddress);
		paramMap.put("applysource", applysource);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//添加用户
			Integer info = assignDao.addAssign(paramMap);
			resultMap.put("result", info);
			bean.setCode(MsgConstant.CODE_SUCCESS_CREATED);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			bean.setData(resultMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		
		return bean;
	}
	
	
	@Override
	public ModelBean payAssign(String id,String assignname,String htreason,String htstatues,String userlist) {
		ModelBean bean = new ModelBean();
		//List list = new ArrayList();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("assignname", assignname);
		paramMap.put("htreason", htreason);
		paramMap.put("htstatues", htstatues);
		paramMap.put("userlist", userlist);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//提交用户
			Integer user=assignDao.payAssign(paramMap);
			resultMap.put("result", user);
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
	public ModelBean scrapAssign(String id,String scrapname,String scrapwhy) {
		ModelBean bean = new ModelBean();
		//List list = new ArrayList();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("scrapname", scrapname);
		paramMap.put("scrapwhy", scrapwhy);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//提交用户
			Integer user=assignDao.scrapAssign(paramMap);
			resultMap.put("result", user);
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
	public Map<String,Object> getAssignId(String id) throws UnsupportedEncodingException {

		ModelResults result = new ModelResults(0,20);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", URLDecoder.decode(id, "UTF-8"));
		paramMap.put("result", result);
		Map<String, Object> propertytList = null;
		try {
			propertytList = assignDao.getAssignId(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		result.setRows(propertytList);
		return propertytList;
	}

	@Override
	public ModelBean getuserlist(String departid) {
		ModelBean bean = new ModelBean();
		List<Map<String, Object>> departList = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("departid", departid);
		try {
		departList =assignDao.getuserlist(paramMap);
		bean.setCode(MsgConstant.CODE_SUCCESS);
		bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		bean.setObj(departList);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	
	

}
