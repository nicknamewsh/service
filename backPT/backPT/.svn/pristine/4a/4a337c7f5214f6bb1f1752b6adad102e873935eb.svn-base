package com.pt.ssm.controller;



import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.po.Rent;
import com.pt.ssm.util.Util;
import com.pt.ssm.service.RentService;
import com.pt.ssm.service.WYBXService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Controller
@RequestMapping("/wybx")
public class WYBXController {
	@Autowired
	private WYBXService wybxService;
	

	@RequestMapping(value="/getBXTongJi", method = RequestMethod.POST)
	@ResponseBody
	public ModelBean getBXTongJi(
			@RequestParam(required = false,value = "departId")Integer departId,
			@RequestParam(required = false,value = "beginTime")String beginTime,
			@RequestParam(required = false,value = "endTime")String endTime
			) throws JSONException, IOException{
		
		ModelBean model = wybxService.getBXTongJi(departId,beginTime,endTime);
		return model;
	}
}
