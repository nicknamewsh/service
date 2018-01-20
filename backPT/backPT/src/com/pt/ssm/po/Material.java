package com.pt.ssm.po;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Material")
public class Material implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String materialName;
	
	private Double materialMoney;
	
	private String personName;
	
	private String materialDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Double getMaterialMoney() {
		return materialMoney;
	}

	public void setMaterialMoney(Double materialMoney) {
		this.materialMoney = materialMoney;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getMaterialDate() {
		return materialDate;
	}

	public void setMaterialDate(String materialDate) {
		this.materialDate = materialDate;
	}
	
	
	
	
}
