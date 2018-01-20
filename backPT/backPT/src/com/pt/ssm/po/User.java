package com.pt.ssm.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
	private static final long serialVersionUID = 7801108216512223194L;
	
	private int  userid;			//用户ID;
	private String  username;		//登录名称;
	private String  password;		//登录密码;
	private String name;			//用户姓名;
	private String intime;			//注册时间;
	private Integer status;			//用户状态：0正常   1删除;
	private Date recordLoginTime;	//本次登录时间;
	private int departid;			//部门ID;
	private String psw;
	
	
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getDepartid() {
		return departid;
	}
	public void setDepartid(int departid) {
		this.departid = departid;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRecordLoginTime() {
		return recordLoginTime;
	}
	public void setRecordLoginTime(Date recordLoginTime) {
		this.recordLoginTime = recordLoginTime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}





}
