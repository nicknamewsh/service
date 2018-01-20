package com.pt.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.constant.MsgConstant;
import com.pt.ssm.dao.MaterialDao;
import com.pt.ssm.po.Material;
import com.pt.ssm.service.MaterialService;
import com.pt.ssm.util.ModelBean;
import com.pt.ssm.util.ModelResults;


@Service
@Transactional
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	private MaterialDao materialDao;
	
	@Override
	public ModelResults getMaterialList(long page, long size,
			String materialName, String personName) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelResults result = new ModelResults(page, size);
		paramMap.put("materialName", materialName);
		paramMap.put("personName", personName);
		paramMap.put("page", page);
		paramMap.put("pageSize", size);
		List<Map<String, Object>> list = null;
		long count = 0;
		try {
			list = materialDao.getMaterialList(paramMap);
			count = materialDao.getMaterialListCount(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		result.setRows(list);
		result.setTotal(count);
		return result;
	}
	@Override
	public ModelBean addMaterialInfo(Material material) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = materialDao.addMaterialInfo(material);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	@Override
	public ModelBean getMaterialInfoById(Integer id) {
		Material m = null;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		ModelBean bean = new ModelBean();
		paramMap.put("id", id);
		try {
			m=materialDao.getMaterialInfoById(paramMap);
			bean.setObj(m);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INVALIDATE_USER);
		}
		return bean;
	}
	@Override
	public ModelBean updateMaterialInfo(Material material) {
		ModelBean bean = new ModelBean();
		try {
			Integer result = materialDao.updateMaterialInfo(material);
			bean.setObj(result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}
	@Override
	public ModelBean delMaterialInfoByIds(long[] ids) {
		ModelBean bean = new ModelBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Integer result = materialDao.delMaterialInfoByIds(ids);
			resultMap.put("result", result);
			bean.setCode(MsgConstant.CODE_SUCCESS);
			bean.setSuccess(MsgConstant.MESSAGE_TRUE);
			bean.setObj(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(MsgConstant.CODE_INTERNALERR);
			bean.setSuccess(MsgConstant.MESSAGE_FALSE);
			bean.setMsg(MsgConstant.MESSAGE_INTERNAL_EXCEPTION);
		}
		return bean;
	}

}
