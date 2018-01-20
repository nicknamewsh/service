package com.pt.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.service.AssignService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

@Controller
@RequestMapping("/assign")
public class AssignController {
	@Autowired
	private AssignService assignService;	
	
	
	@RequestMapping(value = "/getAssignList", method = RequestMethod.POST)
	@ResponseBody
	public ModelResults getAssignList(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "applyname", required = false) String applyname,
			@RequestParam(value = "start", required = false, defaultValue = "0") long start,
			@RequestParam(value = "end", required = false, defaultValue = "20") long end) throws UnsupportedEncodingException {
	
		return  assignService.getAssignList(id, applyname, start, end);
	}
	
	@RequestMapping(value = "/getAssignId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getAssignId(
			@RequestParam(value = "id", required = false) String id
			) throws UnsupportedEncodingException {
	
		return  assignService.getAssignId(id);
	}
	
	
	/**
	 * 添加信息
	 * */
	@RequestMapping(value="/addAssign")
	@ResponseBody
	public ModelBean addAssign(
			@RequestParam(value = "applyname",required=true)String applyname,
			@RequestParam(value = "applycontent",required=true)String applycontent,
			@RequestParam(value = "applyaddress",required=true)String applyaddress,
			@RequestParam(value = "applydate",required=true)String applydate,
			@RequestParam(value = "applysource", required = true) String applysource
			){
		
		ModelBean bean =new ModelBean();
		//后台校验非空
				if(applyname.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("名称"+ MsgConstant.ISNULL);
					return bean;
				}
				if(applycontent.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("内容"+ MsgConstant.ISNULL);
					return bean;
				}
				if(applyaddress.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("地址"+ MsgConstant.ISNULL);
					return bean;
				}
				if(applysource.equals("")){
					bean.setCode(MsgConstant.CODE_INVALID_PARAMS);
					bean.setMsg("申请来源"+ MsgConstant.ISNULL);
					return bean;
				}
	    bean=assignService.addAssign(applyname,applycontent,applyaddress,applysource);
		return bean;
	}
	
	
	/**
	 * 派发
	 * @param Integer id
	 * */
	@RequestMapping(value = "/payAssign")
	@ResponseBody
	public ModelBean payAssign(@RequestParam(value = "id",required = true)String id,
			@RequestParam(value = "assignname",required = true)String assignname,
			@RequestParam(value = "htreason",required = true)String htreason,
			@RequestParam(value = "htstatues",required = true)String htstatues,
			@RequestParam(value = "userlist",required = true)String userlist){
		ModelBean bean=assignService.payAssign(id,assignname,htreason,htstatues,userlist);
		return bean;
	}
	
	/**
	 * 派发
	 * @param Integer id
	 * */
	@RequestMapping(value = "/scrapAssign")
	@ResponseBody
	public ModelBean scrapAssign(@RequestParam(value = "id",required = true)String id,
			@RequestParam(value = "scrapname",required = true)String scrapname,
			@RequestParam(value = "scrapwhy",required = true)String scrapwhy){
		ModelBean bean=assignService.scrapAssign(id,scrapname,scrapwhy);
		return bean;
	}
	/**
	 * 获取depart信息
	 * @param roleid
	 * */
	@RequestMapping(value = "/getuserlist")
	@ResponseBody
	public ModelBean getuserlist(@RequestParam(value = "departid",required = true)String departid){
		return  assignService.getuserlist(departid);
	}
	
	
	
}
