package com.pt.ssm.po;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("rent")
public class Rent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String roomNumber;
	
	private String rentName;
	
	private String beginTime;
	
	private String endTime;
	
	private Double area;
	
	private Double rentMoney;
	
	private Integer statues;
	
	private String beiZhu;
	
	private String isCome;
	
	private Double wyf;
	private Double sdf;
	private Double tcf;
	private Double zzf;
	private Double total;
	
	private String htong;
	
	
	
	public Double getWyf() {
		return wyf;
	}

	public void setWyf(Double wyf) {
		this.wyf = wyf;
	}

	public Double getSdf() {
		return sdf;
	}

	public void setSdf(Double sdf) {
		this.sdf = sdf;
	}

	public Double getTcf() {
		return tcf;
	}

	public void setTcf(Double tcf) {
		this.tcf = tcf;
	}

	public Double getZzf() {
		return zzf;
	}

	public void setZzf(Double zzf) {
		this.zzf = zzf;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getIsCome() {
		return isCome;
	}

	public void setIsCome(String isCome) {
		this.isCome = isCome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRentName() {
		return rentName;
	}

	public void setRentName(String rentName) {
		this.rentName = rentName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(Double rentMoney) {
		this.rentMoney = rentMoney;
	}

	public Integer getStatues() {
		return statues;
	}

	public void setStatues(Integer statues) {
		this.statues = statues;
	}

	public String getBeiZhu() {
		return beiZhu;
	}

	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}

	public String getHtong() {
		return htong;
	}

	public void setHtong(String htong) {
		this.htong = htong;
	}
	
	
}
