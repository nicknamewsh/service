package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

public interface ScrapDao {

	
	List<Map<String, Object>> getScrapList(Map<String, Object> paramMap) throws Exception;
	long getScrapListCount(Map<String, Object> paramMap) throws Exception;
	Map<String, Object> getScrapId(Map<String, Object> paramMap) throws Exception;
}
