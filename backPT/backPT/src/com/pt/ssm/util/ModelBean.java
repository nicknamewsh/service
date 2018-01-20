package com.pt.ssm.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


@Component
public class ModelBean implements Serializable {
private static final long serialVersionUID = 4178871651723984785L;
	
	private boolean success = false;
	private Object obj = null;
	private String msg;
	private int code = 0;
	private Object data;
	private Object model;
	private List<Map<String, Object>> listData;
	
	
	
	public Object getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = model;
	}
	public List<Map<String, Object>> getListData() {
		return listData;
	}
	public void setListData(List<Map<String, Object>> listData) {
		this.listData = listData;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ModelBean() {
		super();
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
public void printJson(Object o,HttpServletResponse response,String callback){
		
		try {
			String json = JSON.toJSONStringWithDateFormat(o, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/html;charset=utf-8");
			if(callback != null && !"".equals(callback)){
				response.getWriter().write(callback + "(" + json + ")");
			}else{
				response.getWriter().write(json);
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




}
