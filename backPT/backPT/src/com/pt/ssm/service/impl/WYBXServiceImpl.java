package com.pt.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.DepartDao;
import com.pt.ssm.dao.WYBXDao;
import com.pt.ssm.po.Depart;
import com.pt.ssm.po.Property;
import com.pt.ssm.service.WYBXService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.Util;


@Service
@Transactional
public class WYBXServiceImpl implements WYBXService{
	
	@Autowired
	private WYBXDao wybxDao;
	@Autowired
	private DepartDao departDao;

	@Override
	public ModelBean getBXTongJi(Integer departId,String beginTime, String endTime) {
		ModelBean bean=new ModelBean();
		ArrayList<Property> list  = new ArrayList<Property>();
		Map<String, Object> mapParam = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("departId", departId);
		map.put("beginTime", beginTime);
		if(endTime != null && endTime!=""){
			endTime=endTime+" 23 59 59";
		}
		map.put("endTime", endTime);
		long r = 0;
		List<Depart> deptList = null;
		try{
			deptList = departDao.getDeptList();
			list = wybxDao.getBXTongJi(map);
			r = wybxDao.getBXTongJiTotal(map);
		 if(!Util.isNull(deptList)){
			 mapParam.put("deptList", deptList);
			 mapParam.put("list", list);
			 mapParam.put("total", r);
			 bean.setCode(MsgConstant.CODE_SUCCESS);
			 bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			 bean.setObj(mapParam);
			 
		 }else{
			 bean.setCode(MsgConstant.CODE_SUCCESS);
			 bean.setSuccess(MsgConstant.MESSAGE_FALSE);
		 }
		}catch(Exception e){
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
			return bean;
		}
		return bean;
	}

}
