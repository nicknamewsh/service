package com.pt.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.service.AuthorityService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	@Autowired
	private AuthorityService authorityService;
	
	/**
	 * 获取列表信息（Authority）
	 * @param departname page  size
	 * */
	@RequestMapping(value = "/getAuthorityList")
	@ResponseBody
	public ModelResults delAuthority(@RequestParam(value ="departname",required = false)String departname,
								 @RequestParam(value ="page",required = false,defaultValue="0")long page,
								 @RequestParam(value ="size",required = false,defaultValue="20")long size) throws Exception{
		return authorityService.showAuthorityList(departname, page, size);
	}

	/**
	 * 获取menu信息
	 * @param roleid
	 * */
	@RequestMapping(value = "/getMenuList")
	@ResponseBody
	public ModelBean getMenuList(@RequestParam(value = "roleid",required = false,defaultValue = "0")long roleid) throws Exception{
		return authorityService.findMenuList(roleid);
	}

	/**
	 * 添加信息
	 * @param roleid menuid
	 * */
	@RequestMapping(value = "/addRm")
	@ResponseBody
	public ModelBean addrm(@RequestParam(value = "roleid")long roleid,
						   @RequestParam(value = "menuid")long[] menuid) throws Exception{
		return authorityService.addrm(roleid, menuid);
	}
	/**
	 * 获取角色列表
	 * @param roleid
	 * */
	@RequestMapping(value = "getRoleMenuList")
	@ResponseBody
	public ModelBean findRoleMenuList(@RequestParam(value = "roleid",required = true)long roleid) throws Exception{
		return authorityService.findRMList(roleid);
	}
	
	/**
	 * 批量删除
	 * @param roleid[]
	 * */
	@RequestMapping(value = "delrm")
	@ResponseBody
	public ModelBean delrm(@RequestParam(value = "roleid",required = true)long[] roleid) throws Exception{
		return authorityService.delrm(roleid);
	}
	/**
	 * 更新列表
	 * @param roleid menuid[]
	 * */
	@RequestMapping(value ="updateRm")
	@ResponseBody
	public ModelBean updateRm(@RequestParam(value = "roleid")long roleid,@RequestParam(value = "menuid",required = false)long[] menuid) throws Exception{
		return authorityService.updateRm(roleid, menuid);
	}
	
}
