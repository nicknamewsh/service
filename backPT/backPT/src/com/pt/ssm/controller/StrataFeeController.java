package com.pt.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.po.StrataFee;
import com.pt.ssm.service.StrataFeeService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;
import com.pt.ssm.util.Util;

@Controller
@RequestMapping("/strataFee")
public class StrataFeeController {
	@Autowired
	private StrataFeeService feeService;
	
	@RequestMapping(value = "getStrataFeeList" ,method = RequestMethod.POST)
	@ResponseBody
	public ModelResults getStrataFeeList(
			@RequestParam(required = false,value = "dong1")String dong,
			@RequestParam(required = false,value = "hao1")String hao,
			@RequestParam(required = true,value = "start")Integer page,
			@RequestParam(required = true,value = "end")Integer size
			){
		ModelResults model = feeService.getStrataFeeList(dong, hao, page, size); 
		return model;
	}
	
	@RequestMapping(value = "getStratFeeById" )
	@ResponseBody
	public ModelBean getStratFeeById(@RequestParam("id")Integer id){
		ModelBean model = feeService.getStrataFeeById(id);
		return model;
		
	}
	
	@RequestMapping(value = "addStrataFee" )
	@ResponseBody
	public  ModelBean addStrataFee(
			@RequestParam("dong")String dong,
			@RequestParam("hao")String hao,
			@RequestParam("hydroPower")Double hydroPower,
			@RequestParam("parking")Double parking,
			@RequestParam("inc")Double inc,
			@RequestParam("startTime")String startTime,
			@RequestParam("endTime")String endTime,
			@RequestParam("beiZhu")String beiZhu
			){
		StrataFee fee = new StrataFee();
		if(Util.isNull(hydroPower)){
			hydroPower = 0.0;
		}if(Util.isNull(parking)){
			parking = 0.0;
		}if(Util.isNull(inc)){
			inc = 0.0;
		}
		
		fee.setDong(dong);
		fee.setHao(hao);
		fee.setHydroPower(hydroPower);
		fee.setParking(parking);
		fee.setInc(inc);
		fee.setStartTime(startTime);
		fee.setEndTime(endTime);
		fee.setBeiZhu(beiZhu);
		ModelBean model = feeService.addStrata(fee);
		return model;
	}
	
	@RequestMapping(value = "updateStrataFee" )
	@ResponseBody
	public ModelBean updateStrataFee(
			@RequestParam("id")Integer id,
			@RequestParam("dong")String dong,
			@RequestParam("hao")String hao,
			@RequestParam("hydroPower")Double hydroPower,
			@RequestParam("parking")Double parking,
			@RequestParam("inc")Double inc,
			@RequestParam("startTime")String startTime,
			@RequestParam("endTime")String endTime,
			@RequestParam("beiZhu")String beiZhu
			){
		StrataFee fee = new StrataFee();
		if(Util.isNull(hydroPower)){
			hydroPower = 0.0;
		}if(Util.isNull(parking)){
			parking = 0.0;
		}if(Util.isNull(inc)){
			inc = 0.0;
		}
		
		fee.setId(id);
		fee.setDong(dong);
		fee.setHao(hao);
		fee.setHydroPower(hydroPower);
		fee.setParking(parking);
		fee.setInc(inc);
		fee.setStartTime(startTime);
		fee.setEndTime(endTime);
		fee.setBeiZhu(beiZhu);
		ModelBean model = feeService.updateStrataFee(fee);
		return model;
	}
	
	@RequestMapping(value = "deleteStrataFee" )
	@ResponseBody
	public ModelBean deleteStrataFee(@RequestParam("id")long[] id){
		ModelBean model = feeService.deleteStrataFee(id);
		return model;
	}
	
	@RequestMapping(value = "getExportExcel" )
	@ResponseBody
	public ModelResults getExportExcel(
			HttpServletRequest request
			){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dong",  request.getParameter("dong")==null?"":request.getParameter("dong"));
		paramMap.put("hao",  request.getParameter("hao")==null?"":request.getParameter("hao"));
		ModelResults model = feeService.getExportExcel(paramMap);
		return model;
	}
}
