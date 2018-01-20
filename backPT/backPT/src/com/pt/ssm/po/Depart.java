package com.pt.ssm.po;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("Depart")
public class Depart implements Serializable{

	private static final long serialVersionUID = 6571083331975908959L;

	private Integer departId;
	
	private String departName;
	
	private Integer dpid;
	
	private String level;
	
	private String orderId;
	
	private String roleId;
	
	private String remark;
	
	private List<Depart> childDepts;

	public List<Depart> getChildDepts() {
		return childDepts;
	}

	public void setChildDepts(List<Depart> childDepts) {
		this.childDepts = childDepts;
	}
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
