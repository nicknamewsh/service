package com.pt.ssm.service;

import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;

public interface AuthorityService {
	ModelResults showAuthorityList(String departname,long page,long size) throws Exception;//role列表
	
	ModelBean findMenuList(long roleid) throws Exception;//列表
	
	ModelBean addrm(long roleid,long[] menuid) throws Exception;//添加role
	
	ModelBean findRMList(long roleid) throws Exception;//通过roleid查找
	
	ModelBean delrm(long[] roleid) throws Exception;//删除role
	
	ModelBean updateRm(long roleid,long[] menuid) throws Exception;//更新role信息
	
}
