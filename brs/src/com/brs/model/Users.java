package com.brs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Users implements Serializable{
	private String userId;
	private String name;
	private String password;
	private String sex;
	private Imgs imgs;
	private String tel;
	private String email;
	private int status;
	private Set<Rental> rental = new HashSet<>();
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Imgs getImgs() {
		return imgs;
	}
	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<Rental> getRental() {
		return rental;
	}
	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}
	public Users() {
		super();
	}
	public Users(String userId, String name, String password, String sex, Imgs imgs, String tel, String email,
			int status, Set<Rental> rental) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.imgs = imgs;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.rental = rental;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", password=" + password + ", sex=" + sex + ", imgs="
				+ imgs + ", tel=" + tel + ", email=" + email + ", status=" + status + "]";
	}
	
}
