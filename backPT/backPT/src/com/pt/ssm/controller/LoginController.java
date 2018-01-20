package com.pt.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.service.LoginService;
import com.pt.ssm.util.ModelBean;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	/**
	 * 登录
	 * @param session
	 * @param name		用户名
	 * @param password	密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelBean login(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {
		return loginService.login(name, password);	
	}
	
	
	/**
	 * 登录
	 * @param session
	 * @param username		用户名
	 * @param password	密码
	 * @return
	 */
	@RequestMapping(value = "/loginJeep", method = RequestMethod.POST)
	@ResponseBody
	public ModelBean loginJeep(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		return loginService.login(username, password);	
	}

}
