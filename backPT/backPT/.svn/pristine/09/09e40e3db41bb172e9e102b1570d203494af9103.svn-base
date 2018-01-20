package com.pt.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.UserDao;
import com.pt.ssm.po.User;
import com.pt.ssm.service.UserService;
import com.pt.ssm.util.MD5Util;
import com.pt.ssm.util.ModelBean;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public ModelBean addUserInfo(String username, String password, String name,String departlist) {
		ModelBean bean = new ModelBean();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("psw", password);
		password=MD5Util.encryptionMD5(password);
		paramMap.put("password", password);
		paramMap.put("username", username);
		paramMap.put("name", name);
		paramMap.put("departlist", departlist);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//根据username查询用户数量，新增重名验证
			Integer hasUser = userDao.getUserByName(paramMap);
			if(hasUser > 0 ){
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			}else{
				//添加用户
				Integer info = userDao.addUser(paramMap);
				resultMap.put("result", info);
				bean.setCode(MsgConstant.CODE_SUCCESS_CREATED);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
				bean.setData(resultMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		
		return bean;
	}
	@Override
	public List<User> showUser() throws Exception {
		//遍历用户信息
		List<User> users=userDao.getUser();
		
		return users;
	}

	@Override
	public ModelBean detUserById(String userId) {
		ModelBean bean = new ModelBean();
		String[] info = userId.split(",");
		Integer[] userid = new Integer[info.length]; 
		//List list = new ArrayList();
		try {
			for(int i = 0; i <info.length; i++){
				userid[i] = Integer.parseInt(info[i]); 
				//list.add(userid[i]);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//System.out.println(userid);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			//删除用户
			Integer user=userDao.delUserById(userid);
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
	public ModelBean updateInfoById(String username, String password,
			String name, Integer userId,Integer departid) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		map.put("psw", password);
		map.put("username", username);
		password=MD5Util.encryptionMD5(password);
		map.put("password", password);
		map.put("name", name);
		map.put("userid", userId);
		map.put("departid", departid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//根据username和userid查询用户数量，修改重名验证
			Integer hasUserName=userDao.findUserName(map);
			if(hasUserName > 0){
				bean.setCode(MsgConstant.CODE_SUCCESS);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			}else{
				//修改用户信息
				Integer result=userDao.updateUser(map);
				resultMap.put("result", result);
				bean.setCode(MsgConstant.CODE_SUCCESS_UPDATED);
				bean.setSuccess(MsgConstant.MESSAGE_TRUE);
				bean.setObj(resultMap);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

	@Override
	public ModelBean getUserByID(Integer userId) {
		ModelBean bean = new ModelBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//根据ID查询用户信息
			User userInfo=userDao.getUserByID(map);
			resultMap.put("userInfo", userInfo);
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
