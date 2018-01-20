package com.pt.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.AuthorityDao;
import com.pt.ssm.po.RoleMenu;
import com.pt.ssm.service.AuthorityService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	private AuthorityDao authorityDao;
	/**
	 * 获取role列表
	 * @param departname,page, size
	 * */
	@Override
	public ModelResults showAuthorityList(String departname, long page,
			long size){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("departname", departname);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> authorityList = null;
		Map<String,Object> map = new HashMap<String, Object>();
		long count = 0;
		try {
			authorityList = authorityDao.getAuthorityList(paramMap);
			count = authorityDao.getAuthorityListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(authorityList);
		result.setTotal(count);
		return result;
	}
	/**
	 * 获取menu
	 * @param roleid
	 * */
	@Override
	public ModelBean findMenuList(long roleid) {
		List<Map<String, Object>> menuList = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("roleid", roleid);
		try {
			menuList=authorityDao.getMenuList(paramMap);
			bean.setListData(menuList);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
		}
		return bean;
	}
	/**
	 * 添加中间表role-menu信息
	 * @param roleid & menuid[]
	 * */
	@Override
	public ModelBean addrm(long roleid, long[] menuid) throws Exception {
		ModelBean bean = new ModelBean();
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		long maxId = authorityDao.findMaxId();
		for(int m = 0;m < menuid.length; m++){
			RoleMenu mn = new RoleMenu();
			mn.setId(maxId+m+1);
			mn.setMenuid(menuid[m]);
			mn.setRoleid(roleid);
			list.add(mn);
		}
		try {
			Integer result = authorityDao.addrm(list);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	/**
	 * 通过roleid查找
	 * @param roleid
	 * */
	@Override
	public ModelBean findRMList(long roleid){
		ModelBean bean = new ModelBean();
		List<Map<String, Object>> menuList = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleid", roleid);
		try {
			menuList = authorityDao.getRoleMenuList(paramMap);
			bean.setListData(menuList);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	
	/**
	 * 通过roleid批量删除信息
	 * @param roleid[]
	 * */
	@Override
	public ModelBean delrm(long[] roleid) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			Integer result = authorityDao.delrm(roleid);
			resultMap.put("result", result);
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
	
	/**
	 * 更新中间表信息
	 * @param roleid&menuid
	 * */
	@Override
	public ModelBean updateRm(long roleid, long[] menuid) throws Exception{
		ModelBean bean = new ModelBean();
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		Map<String,Object> paramMap = new HashMap<String, Object>();
		long maxId = authorityDao.findMaxId();
		paramMap.put("roleid", roleid);
		for(int y = 0; y < menuid.length; y++){
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setId(maxId + 1 + y);
			roleMenu.setRoleid(roleid);
			roleMenu.setMenuid(menuid[y]);
			list.add(roleMenu);
		}
		try {
			Integer one = authorityDao.delRmOneRole(paramMap);
			if(menuid.length != 0 && menuid[0] != 0){
			Integer result = authorityDao.updaterm(list);
			}
			//bean.setObj(result);
			bean.setData(one);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

}
