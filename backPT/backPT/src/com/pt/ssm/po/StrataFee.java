package com.pt.ssm.po;

import org.apache.ibatis.type.Alias;

/**
 * 物业费表
 * @author Mr.Wang
 *
 */
@Alias("strataFee")
public class StrataFee {
	private static final long serialVersionUID = 7801108216512223194L;
	
	private Integer id;
	private String dong;//栋
	private String hao;//号
	private Double hydroPower;//水电费
	private Double parking;//停车费
	private Double inc;//增值费
	private String	startTime;
	private String endTime;
	private String beiZhu;
	public StrataFee() {
		super();
	}
	public StrataFee(Integer id, String dong, String hao, Double hydroPower,
			Double parking, Double inc, String startTime, String endTime,
			String beiZhu) {
		super();
		this.id = id;
		this.dong = dong;
		this.hao = hao;
		this.hydroPower = hydroPower;
		this.parking = parking;
		this.inc = inc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.beiZhu = beiZhu;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getHao() {
		return hao;
	}
	public void setHao(String hao) {
		this.hao = hao;
	}
	public Double getHydroPower() {
		return hydroPower;
	}
	public void setHydroPower(Double hydroPower) {
		this.hydroPower = hydroPower;
	}
	public Double getParking() {
		return parking;
	}
	public void setParking(Double parking) {
		this.parking = parking;
	}
	public Double getInc() {
		return inc;
	}
	public void setInc(Double inc) {
		this.inc = inc;
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
	public String getBeiZhu() {
		return beiZhu;
	}
	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}
	
	
	
	
}
