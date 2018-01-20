package com.pt.ssm.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.ManagementDao;
import com.pt.ssm.service.ManagementService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;



@Service
public class ManagementServiceImpl implements ManagementService  {
	@Autowired
	private ManagementDao managementDao;

	@Override
	public ModelResults getUserList(String username, String name, long start, long end) throws UnsupportedEncodingException {
		ModelResults result = new ModelResults(start, end);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", URLDecoder.decode(username, "UTF-8"));
		paramMap.put("name", URLDecoder.decode(name, "UTF-8"));
		paramMap.put("result", result);
		
		List<Map<String, Object>> userList = null;
		long count = 0;
		try {
			userList = managementDao.getUserList(paramMap);
			count = managementDao.getUserListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(userList);
		result.setTotal(count);
		return result;
	}
	
	@Override
	public ModelResults getRoleList( String rolename, long start, long end) throws UnsupportedEncodingException {
		ModelResults result = new ModelResults(start, end);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rolename", URLDecoder.decode(rolename, "UTF-8"));
		paramMap.put("result", result);
		List<Map<String, Object>> roleList = null;
		long count = 0;
		try {
			roleList = managementDao.getRoleList(paramMap);
			count = managementDao.getRoleListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(roleList);
		result.setTotal(count);
		return result;
	}

	@Override
	public ModelBean getOneData(Integer roleid) {
		
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = null;
		try {
			resultMap = managementDao.getOneData(roleid);
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
	public ModelBean updateRoleById(Integer roleid,String roleName) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rolename", roleName);
		resultMap.put("roleid", roleid);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			Integer info = managementDao.updateRole(resultMap);
			paramMap.put("result", info);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			bean.setObj(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean addRole(String rolename) {
		ModelBean bean = new ModelBean();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rolename", rolename);
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			Map<String,Object> map2 = managementDao.getOneRole(map);
			System.out.println(map2);
			if(map2 == null){
			Integer info = managementDao.addRole(map);
			resultMap.put("result", info);
			}
			bean.setCode(MsgConstant.CODE_SUCCESS);
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
	public ModelBean delRoleById(long[] roleid) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Integer result = managementDao.delRole(roleid);
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
	public ModelBean getRole() {
		ModelBean bean = new ModelBean();
		List<Map<String, Object>> roleList = null;
		try {
		roleList =managementDao.getRole();
		bean.setCode(MsgConstant.CODE_SUCCESS);
		bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		bean.setObj(roleList);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean getDepart() {
		ModelBean bean = new ModelBean();
		List<Map<String, Object>> departList = null;
		try {
		departList =managementDao.getDepart();
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

	@Override
	public ModelBean findRoleInfo(String rolename) {
		ModelBean bean = new ModelBean();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rolename", rolename);
		Map<String, Object> resultMap = null;
		try {
			resultMap = managementDao.getOneRole(param);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			bean.setObj(resultMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
}
