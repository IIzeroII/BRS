package com.brs.model;

import java.io.Serializable;

public class Admins implements Serializable{
	private String adminId;
	private String password;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Admins() {
		super();
	}
	@Override
	public String toString() {
		return "Admins [adminId=" + adminId + ", password=" + password + ", status=" + status + "]";
	}
	

}
