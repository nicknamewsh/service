package com.pt.ssm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.service.MenuService;
import com.pt.ssm.util.ModelBean;


@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	/**
	 * 查询菜单
	 * @return menu
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	@ResponseBody
	public ModelBean getMenuList(@RequestParam(value = "roleId",required = false)String roleId){
		ModelBean bean =	menuService.getMenuList(roleId);
		return bean;
		
	}
}
