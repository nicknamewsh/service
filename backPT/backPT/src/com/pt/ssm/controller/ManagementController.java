package com.pt.ssm.controller;


import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.service.ManagementService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Controller
@RequestMapping("/management")
public class ManagementController {
	@Autowired
	private ManagementService managementService;
	
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	@ResponseBody
	public ModelResults getUserList(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "start", required = false, defaultValue = "0") long start,
			@RequestParam(value = "end", required = false, defaultValue = "20") long end) throws UnsupportedEncodingException {
	
		return  managementService.getUserList(username, name, start, end);
	}
	
	
	@RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
	@ResponseBody
	public ModelResults getRoleList(
			@RequestParam(value = "rolename", required = false) String rolename,
			@RequestParam(value = "start", required = false, defaultValue = "0") long start,
			@RequestParam(value = "end", required = false, defaultValue = "20") long end) throws UnsupportedEncodingException{
	
		return  managementService.getRoleList(rolename, start, end);
		
	}
	
	/**
	 * 通过roleid获取信息
	 * @param roleid
	 * */
	@RequestMapping(value = "/getOneData")
	@ResponseBody
	public ModelBean getOneData(@RequestParam(value = "roleid",required=true)Integer roleid){
		return  managementService.getOneData(roleid);
	}
	
	/**
	 * 通过roleid更新信息
	 * @param roleid
	 * @param rolename
	 * */
	@RequestMapping(value = "/updateRole")
	@ResponseBody
	public ModelBean updateRole(@RequestParam(value = "roleid",required = true)Integer roleid,
								@RequestParam(value = "rolename",required = true)String rolename){
		return managementService.updateRoleById(roleid, rolename);
	}
	/**
	 * 添加role信息
	 * @param rolename
	 * */
	@RequestMapping(value = "/addRole")
	@ResponseBody
	public ModelBean addRole(@RequestParam(value = "rolename",required = true)String rolename){
		return managementService.addRole(rolename);
	}
	
	
	/**
	 * 批量删除role信息
	 * @param roleid[]
	 * */
	@RequestMapping(value = "delRole")
	@ResponseBody
	public ModelBean delRole(@RequestParam(value = "roleid",required = true)long[] roleId){
		ModelBean bean= managementService.delRoleById(roleId);
		return bean;
	}
	
	/**
	 * 获取role信息
	 * @param roleid
	 * */
	@RequestMapping(value = "/getRole")
	@ResponseBody
	public ModelBean getRole(){
		return  managementService.getRole();
	}
	
	/**
	 * 获取depart信息
	 * @param roleid
	 * */
	@RequestMapping(value = "/getDepart")
	@ResponseBody
	public ModelBean getDepart(){
		return  managementService.getDepart();
	}
	
	
	
	/**
	 * 获取单个role信息
	 * @param rolename
	 * */
	@RequestMapping(value = "/getRoleByName")
	@ResponseBody
	public ModelBean findRoleByName(@RequestParam(value = "rolename")String rolename){
		return managementService.findRoleInfo(rolename);
	}
	
	
	
	
	
}
