package com.brs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Imgs implements Serializable{
	private String imgId;
	private String path;
	private Set<Users> users = new HashSet<>();
	private Set<Bicycle> bicycle = new HashSet<>();
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public Set<Bicycle> getBicycle() {
		return bicycle;
	}
	public void setBicycle(Set<Bicycle> bicycle) {
		this.bicycle = bicycle;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Imgs() {
		super();
	}
	public Imgs(String imgId, String path, Set<Users> users, Set<Bicycle> bicycle) {
		super();
		this.imgId = imgId;
		this.path = path;
		this.users = users;
		this.bicycle = bicycle;
	}
	@Override
	public String toString() {
		return "Imgs [imgId=" + imgId + ", path=" + path + "]";
	}
	

}
