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
import com.pt.ssm.dao.MaintainDao;
import com.pt.ssm.po.Property;
import com.pt.ssm.service.MaintainService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Service
@Transactional
public class MaintainServiceImpl implements MaintainService{

	@Autowired
	private MaintainDao maintainDao;
	private List<Property> propertyList = new ArrayList<Property>();
	
	
	@Override
	public ModelResults getMaintainList(String id, String applyname, long start, long end) throws UnsupportedEncodingException {
		ModelResults result = new ModelResults(start, end);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", URLDecoder.decode(id, "UTF-8"));
		paramMap.put("applyname", URLDecoder.decode(applyname, "UTF-8"));
		paramMap.put("result", result);
		
		List<Map<String, Object>> propertytList = null;
		long count = 0;
		try {
			propertytList = maintainDao.getMaintainList(paramMap);
			count = maintainDao.getMaintainListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(propertytList);
		result.setTotal(count);
		return result;
	}
	
	
	@Override
	public ModelBean upMaintain(String id,String maintainname,String repairmoney,String materialmoney,
			String completecontent,String maintaindate,String archivename) {
		ModelBean bean = new ModelBean();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("maintainname", maintainname);
		paramMap.put("repairmoney", repairmoney);
		paramMap.put("materialmoney", materialmoney);
		paramMap.put("completecontent", completecontent);
		paramMap.put("archivename", archivename);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Integer info = maintainDao.upMaintain(paramMap);
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
	public Map<String,Object> getMaintainId(String id) throws UnsupportedEncodingException {

		ModelResults result = new ModelResults(0,20);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", URLDecoder.decode(id, "UTF-8"));
		paramMap.put("result", result);
		Map<String, Object> propertytList = null;
		try {
			propertytList = maintainDao.getMaintainId(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		result.setRows(propertytList);
		return propertytList;
	}


	@Override
	public Map<String, Object> getUsername(String id) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", URLDecoder.decode(id, "UTF-8"));
		Map<String, Object> List = null;
		try {
			List = maintainDao.getUsername(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return List;
	}

}

