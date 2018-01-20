package com.pt.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.po.User;
import com.pt.ssm.service.UserService;
import com.pt.ssm.util.ModelBean;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 添加用户信息
	 * @param username 登录名称
	 * @param password 密码
	 * @param name     用户姓名
	 * */
	@RequestMapping(value="/addUser")
	@ResponseBody
	public ModelBean addUser(
			@RequestParam(value = "username",required=true)String userName,
			@RequestParam(value = "password",required=true)String password,
			@RequestParam(value = "name",required=true)String name,
			@RequestParam(value = "departlist", required = true) String departlist
			){
		ModelBean bean =new ModelBean();
		//后台校验非空
				if(userName.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("登录名称"+ MsgConstant.ISNULL);
					return bean;
				}
				if(name.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("用户姓名"+ MsgConstant.ISNULL);	
					return bean;
				}
				if(password.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("密码"+ MsgConstant.ISNULL);
					return bean;
				}
				if(departlist.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("部门"+ MsgConstant.ISNULL);
					return bean;
				}
	    bean=userService.addUserInfo(userName, password, name,departlist);
		return bean;
	}
	/**
	 * 查询用户信息
	 * @return user
	 * @throws Exception 
	 * */
	@RequestMapping(value = "/showUser",method = RequestMethod.GET)
	@ResponseBody
	public List<User> showUser() throws Exception{
		List <User> users = userService.showUser();
		return users;
	}
	
	/**
	 * 删除用户
	 * @param Integer userId
	 * */
	@RequestMapping(value = "/delUser")
	@ResponseBody
	public ModelBean del(@RequestParam(value = "userId",required = true)String userId){
		ModelBean bean=userService.detUserById(userId);
		return bean;
	}
	
	/**
	 * 修改信息
	 * @param username
	 * @param name
	 * @param password
	 * */
	@RequestMapping(value = "/update")
	@ResponseBody
	public ModelBean update(
			@RequestParam(value = "username")String username,
			@RequestParam(value = "name")String name,
			@RequestParam(value = "password")String password,
			@RequestParam(value = "userid")Integer userid,
			@RequestParam(value = "departid")Integer departid
			
			){
			
		ModelBean bean =new ModelBean();
		//后台校验非空
		if(username.equals("")){
			bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
			bean.setMsg("登录名称"+ MsgConstant.ISNULL);
			return bean;
		}
		if(name.equals("")){
			bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
			bean.setMsg("用户姓名"+ MsgConstant.ISNULL);	
			return bean;
		}
		if(password.equals("")){
			bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
			bean.setMsg("密码"+ MsgConstant.ISNULL);
			return bean;
		}
		if(departid.equals("")){
			bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
			bean.setMsg("部门"+ MsgConstant.ISNULL);
			return bean;
		}
	    bean = userService.updateInfoById(username, password, name, userid, departid);
		return bean;
	}
	
	/**
	 * 通过userid获取用户信息
	 * @param userid
	 * */
	@RequestMapping(value = "/getUserByID")
	@ResponseBody
	public ModelBean getUserByID(@RequestParam(value = "userid")Integer userId){
		ModelBean bean = userService.getUserByID(userId);
		return bean;
	}
	
}
