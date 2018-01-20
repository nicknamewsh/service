package com.pt.ssm.service;

import com.pt.ssm.util.ModelBean;

public interface DepartService {

	/**
	 * 部门列表
	 * @return
	 */
	ModelBean getDepartList();

	/**
	 * 根据id查询部门信息   详情页面
	 * @param departId
	 * @return
	 */
	ModelBean getDeptInfoById(Integer departId);

	/**
	 * 修改部门信息
	 * @param deptId
	 * @param deptName
	 * @param roleId
	 * @return
	 */
	ModelBean updateDept(Integer deptId, String deptName,String roleId);

	/**
	 * 添加部门信息
	 * @param deptId
	 * @param deptName
	 * @param roleId
	 * @return
	 */
	ModelBean addDept(Integer deptId, String deptName,String roleId);

	/**
	 * 查询dpid==deptid的部门，如果能查到，说明有子部门  则该部门不许删除
	 * @param deptId
	 * @return
	 */
	ModelBean getDpidInDeptId(Integer deptId);

	/**
	 * 删除部门
	 * @param deptId
	 * @return
	 */
	ModelBean deteleDept(Integer deptId);

	/**
	 * 得到权限列表
	 * @return
	 */
	ModelBean getRoleList();

	ModelBean getPidsById(Integer deptId);

	ModelBean getDepartListBy37();

}