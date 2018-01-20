package com.pt.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.service.LoginService;
import com.pt.ssm.service.WxService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Controller
@RequestMapping("/wx")
public class WxController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private WxService wxService;

	@RequestMapping(value="/upRepair")
	@ResponseBody
	public ModelBean upRepair(HttpServletRequest request) throws JSONException, IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username",  request.getParameter("username")==null?"":request.getParameter("username"));
		paramMap.put("name",  request.getParameter("name")==null?"":request.getParameter("name"));
		paramMap.put("psw", request.getParameter("psw")==null?"":request.getParameter("psw"));
		paramMap.put("phone", request.getParameter("phone")==null?"":request.getParameter("phone"));
		
		ModelBean model = loginService.upRepair(paramMap);
		return model;
	}
	
	@RequestMapping(value="/wxaddbx")
	@ResponseBody
	public ModelBean wxaddbx(HttpServletRequest request) throws JSONException, IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bxr", request.getParameter("bxr") == null ? "" : request.getParameter("bxr"));
		paramMap.put("phone", request.getParameter("phone") == null ? "" : request.getParameter("phone"));
		paramMap.put("nr",  request.getParameter("nr")==null?"":request.getParameter("nr"));
		paramMap.put("dz",  request.getParameter("dz")==null?"":request.getParameter("dz"));
		paramMap.put("applysource", request.getParameter("applysource")==null?"":request.getParameter("applysource"));
		
		ModelBean model = wxService.wxaddbx(paramMap);
		return model;
	}
	
	
	@RequestMapping(value="/wxList")
	@ResponseBody
	public ModelResults wxList(HttpServletRequest request) throws JSONException, IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name",  request.getParameter("name")==null?"":request.getParameter("name"));
		return  wxService.wxList(paramMap);
	}
	
	/**
	 * 登录
	 * @param session
	 * @param name		用户名
	 * @param password	密码
	 * @return
	 */
	@RequestMapping(value = "/wxlogin", method = RequestMethod.POST)
	@ResponseBody
	public ModelBean login(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {
		return loginService.wxlogin(name, password);	
	}
	
	
	/**
	 * 通过id获取信息
	 * @param id
	 * */
	@RequestMapping(value = "/mxprocess")
	@ResponseBody
	public ModelBean mxprocess(@RequestParam(value = "id")String id){
		ModelBean bean = wxService.mxprocess(id);
		return bean;
	}
	
	@RequestMapping(value="/cfname")
	@ResponseBody
	public ModelBean cfname(HttpServletRequest request) throws JSONException, IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name",  request.getParameter("name")==null?"":request.getParameter("name"));
		
		ModelBean model = wxService.cfname(paramMap);
		return model;
	}
	
}
