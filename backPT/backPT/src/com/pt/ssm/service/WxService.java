package com.pt.ssm.service;

import java.util.Map;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface WxService {

	ModelResults wxList(Map<String, Object> paramMap);
	ModelBean wxaddbx(Map<String, Object> paramMap);
	ModelBean mxprocess(String id);
	ModelBean cfname(Map<String, Object> paramMap);
}
