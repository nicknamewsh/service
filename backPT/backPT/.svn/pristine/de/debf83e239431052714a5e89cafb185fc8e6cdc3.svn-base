package com.pt.ssm.po;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("customerRight")
public class CustomerRight implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer customerDataId;//关联PT_CUSTOMERDATA 表id
	
	private String startTime;//本次租金开始时间
	
	private String endTime; // 本次租金结束时间
	
	private Double fanzhu;//房租
	
	private Integer isPay;//0没有交费，1 已经交费
	
	private String beizhu;
	
	private Integer isDal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerDataId() {
		return customerDataId;
	}

	public void setCustomerDataId(Integer customerDataId) {
		this.customerDataId = customerDataId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Double getFanzhu() {
		return fanzhu;
	}

	public void setFanzhu(Double fanzhu) {
		this.fanzhu = fanzhu;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getIsDal() {
		return isDal;
	}

	public void setIsDal(Integer isDal) {
		this.isDal = isDal;
	}
	
	
	
}
