package com.pt.ssm.po;

import java.io.Serializable;


public class Model implements Serializable {
	private static final long serialVersionUID = 7801108216512223194L;
	
	private WxUser wxuser;
	private User user;
	private Role role;
	private Depart depart;
	private Menu menu;
	
	
	public WxUser getWxuser() {
		return wxuser;
	}
	public void setWxuser(WxUser wxuser) {
		this.wxuser = wxuser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
}
