package com.pt.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.DepartDao;
import com.pt.ssm.dao.LoginDao;
import com.pt.ssm.po.Model;
import com.pt.ssm.po.Role;
import com.pt.ssm.po.User;
import com.pt.ssm.po.WxUser;
import com.pt.ssm.service.LoginService;
import com.pt.ssm.util.MD5Util;
import com.pt.ssm.util.ModelBean;



@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private DepartDao deptDao;
	
	@Override
	public ModelBean login(String name, String password) {
		ModelBean bean = new ModelBean();
		Map<String, String> paramMap = new HashMap<String, String>();
		//MD5对密码进行加密
		password = MD5Util.encryptionMD5(password);
		//把用户名和密码放入map中
		paramMap.put("name", name);
		paramMap.put("password", password);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User user = null;
		Role role = new Role();
		//扩展类，用于存放User  Role .....等po
		Model model = new Model();
		
		try {
			//这里通过user--->departid----->dept----->roleId
			
			//通过用户名和密码查询出user对象
			user = loginDao.login(paramMap);
			
			if(user != null ){
				//在user中获取departid
				Integer deptId = user.getDepartid();
				//通过刚刚获取到的departid 查询dept信息
				Map<String, Object> dept = deptDao.getDeptInfoById(deptId);
				if(dept != null){
					if(dept.get("ROLEID") != null){
						//从dept中获取roleid 存入Role对象中
						role.setRoleId(dept.get("ROLEID").toString());
					}
				}
				
				model.setUser(user);
				model.setRole(role);
				resultMap.put("user", user);
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
				bean.setObj(resultMap);
				bean.setModel(model);
			}else{
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_FALSE);
				bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
				bean.setObj(resultMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
			return bean;
		}
		return bean;
	}

	@Override
	public ModelBean upRepair(Map<String, Object> paramMap) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = loginDao.upRepair(paramMap);
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
	public ModelBean wxlogin(String name, String password) {
		ModelBean bean = new ModelBean();
		Map<String, String> paramMap = new HashMap<String, String>();
		
		//把用户名和密码放入map中
		paramMap.put("name", name);
		paramMap.put("password", password);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		WxUser wxuser = null;
		//扩展类，用于存放User  Role .....等po
		Model model = new Model();
		
		try {
			wxuser = loginDao.wxlogin(paramMap);
			
			if(wxuser != null ){
				model.setWxuser(wxuser);
				resultMap.put("wxuser", wxuser);
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
				bean.setObj(resultMap);
				bean.setModel(model);
			}else{
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_FALSE);
				bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
				bean.setObj(resultMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
			return bean;
		}
		return bean;
	}
	
}
