package com.pt.ssm.controller;



import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.ssm.po.Material;
import com.pt.ssm.util.Util;
import com.pt.ssm.service.MaterialService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	

	@RequestMapping(value="/getMaterialList")
	@ResponseBody
	public ModelResults getMaterialList(
			@RequestParam(value ="materialName",required = false)String materialName,
			@RequestParam(value ="personName",required = false)String personName,
			@RequestParam(value ="start",required = false,defaultValue="0")long page,
			@RequestParam(value ="end",required = false,defaultValue="20")long size
			) throws JSONException, IOException{
		
		ModelResults model = materialService.getMaterialList(page,size,materialName,personName);
		return model;
	}
	
	
	@RequestMapping(value="/addMaterialInfo")
	@ResponseBody
	public ModelBean addMaterialInfo(
			@RequestParam(value ="materialName",required = false)String materialName,
			@RequestParam(value ="personName",required = false)String personName,
			@RequestParam(value="materialMoney",required = false)Double materialMoney,
			@RequestParam(value="materialDate",required = false)String materialDate
			) throws JSONException, IOException{
		Material material = new Material();
		if(Util.isNull(materialMoney)){
			materialMoney = 0.0;
		}
		material.setMaterialDate(materialDate);
		material.setMaterialMoney(materialMoney);
		material.setMaterialName(materialName);
		material.setPersonName(personName);
		
		ModelBean model = materialService.addMaterialInfo(material);
		return model;
	}
	
	
	@RequestMapping(value="/getMaterialInfoById")
	@ResponseBody
	public ModelBean getMaterialInfoById(
			@RequestParam(value="id",required = true)Integer id
			) throws JSONException, IOException{
		ModelBean model = materialService.getMaterialInfoById(id);
		return model;
	}
	
	
	@RequestMapping(value="/updateMaterialInfo")
	@ResponseBody
	public ModelBean updateMaterialInfo(
			@RequestParam(value="id",required = true)Integer id,
			@RequestParam(value ="materialName",required = false)String materialName,
			@RequestParam(value ="personName",required = false)String personName,
			@RequestParam(value="materialMoney",required = false)Double materialMoney,
			@RequestParam(value="materialDate",required = false)String materialDate
			) throws JSONException, IOException{
		Material material = new Material();
		if(Util.isNull(materialMoney)){
			materialMoney = 0.0;
		}
		material.setMaterialDate(materialDate);
		material.setMaterialMoney(materialMoney);
		material.setMaterialName(materialName);
		material.setPersonName(personName);
		material.setId(id);
		ModelBean model = materialService.updateMaterialInfo(material);
		return model;
	}
	
	
	
	/**
	 * 批量删除
	 * @param roleid[]
	 * */
	@RequestMapping(value = "delMaterialInfoByIds")
	@ResponseBody
	public ModelBean delMaterialInfoByIds(@RequestParam(value = "ids",required = true)long[] ids) throws Exception{
		return materialService.delMaterialInfoByIds(ids);
	}
}
