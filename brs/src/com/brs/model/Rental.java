package com.brs.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.brs.utils.GUtils;

public class Rental implements Serializable{
	private String id;
	private Users users;
	private Bicycle bicycle;
	private Timestamp startDate;
	private Timestamp endDate;
	private int number; 
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Rental() {
		super();
	}
	public Rental(String id, Users users, Bicycle bicycle, Timestamp startDate, Timestamp endDate, int number,
			int status) {
		super();
		this.id = id;
		this.users = users;
		this.bicycle = bicycle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.number = number;
		this.status = status;
	}
	/**
	 * hql构造法
	 * @param id
	 * @param users
	 * @param bicycle
	 * @param startDate
	 * @param endDate
	 * @param number
	 * @param status
	 */
	public Rental(String id, Users users, Bicycle bicycle, Object startDate, Object endDate, int number,
			int status) {
		super();
		this.id = id;
		this.users = users;
		this.bicycle = bicycle;
		this.startDate = GUtils.stringToTimestamp(startDate.toString());
		this.endDate = GUtils.stringToTimestamp(endDate.toString());
		this.number = number;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Rental [id=" + id + ", users=" + users + ", bicycle=" + bicycle + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", number=" + number + ", status=" + status + "]";
	}
	
}
