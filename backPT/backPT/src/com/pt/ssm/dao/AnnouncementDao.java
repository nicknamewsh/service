package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.Announcement;


/**
 * 申请公告
 * */
public interface AnnouncementDao {
	//查询
	List<Map<String, Object>> getData(Map<String,Object> param) throws Exception;
	long getCount(Map<String,Object> param) throws Exception;
	
	
	//添加
	int addAnnounce(Map<String,Object> param) throws Exception;
	
	//删除
	int deleteAnnounce(long[] list) throws Exception;
	
	//修改
	int updateAnnounce(Map<String,Object> param) throws Exception;
	
	//查询一个
	Announcement getOneById(long id) throws Exception;
	
	//审核列表
	List<Map<String, Object>> getDatash(Map<String,Object> param) throws Exception;
	long getCountsh(Map<String,Object> param) throws Exception;
	
	//发布
	List<Map<String, Object>> getDatafb(Map<String,Object> param) throws Exception;
	long getCountfb(Map<String,Object> param) throws Exception;
	
	//修改状态
	int updateStatues(Map<String,Object> param) throws Exception;
	
	int updateshenhe(Map<String, Object> param) throws Exception;
	
	List<Map<String, Object>> getData1(Map<String, Object> param);
	
	String getdepa(Map<String, Object> param);
		
}
