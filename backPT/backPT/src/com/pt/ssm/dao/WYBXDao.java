package com.pt.ssm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pt.ssm.po.Property;

public interface WYBXDao {

	ArrayList<Property> getBXTongJi(Map<String, Object> map);

	long getBXTongJiTotal(Map<String, Object> map);


}
