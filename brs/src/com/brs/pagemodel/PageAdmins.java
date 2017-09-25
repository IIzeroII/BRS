package com.brs.pagemodel;

import java.io.Serializable;

public class PageAdmins implements Serializable{
	private String adminId;
	private String password;
	private String password2;
	private int status;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PageAdmins() {
		super();
	}
	public PageAdmins(String adminId, String password, String password2, int status) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.password2 = password2;
		this.status = status;
	}
	@Override
	public String toString() {
		return "PageAdmins [adminId=" + adminId + ", password=" + password + ", password2=" + password2 + ", status="
				+ status + "]";
	}
	
	
}
