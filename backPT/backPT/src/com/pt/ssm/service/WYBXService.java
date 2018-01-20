package com.pt.ssm.service;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface WYBXService {

	ModelBean getBXTongJi(Integer departId, String beginTime, String endTime);

}
