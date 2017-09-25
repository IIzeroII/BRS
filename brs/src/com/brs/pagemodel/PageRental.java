package com.brs.pagemodel;

import java.io.Serializable;
import java.sql.Timestamp;

import com.brs.model.Bicycle;
import com.brs.model.Users;

public class PageRental implements Serializable{
	private String id;
	private Timestamp startDate;
	private Timestamp endDate;
	private int number; 
	private int status;
	//金额
	private int money;
	
	private int op;
	
	//搜索内容
	private String searchContent;
	
	private String userId;
	private String userImgId;
	private String userName;
	
	private String bicycleImgId;
	private String type;
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserImgId() {
		return userImgId;
	}
	public void setUserImgId(String userImgId) {
		this.userImgId = userImgId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBicycleImgId() {
		return bicycleImgId;
	}
	public void setBicycleImgId(String bicycleImgId) {
		this.bicycleImgId = bicycleImgId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public PageRental() {
		super();
	}
	public PageRental(String id, Timestamp startDate, Timestamp endDate, int number, int status, int money, int op,
			String searchContent, String userId, String userImgId, String userName, String bicycleImgId, String type,
			int price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.number = number;
		this.status = status;
		this.money = money;
		this.op = op;
		this.searchContent = searchContent;
		this.userId = userId;
		this.userImgId = userImgId;
		this.userName = userName;
		this.bicycleImgId = bicycleImgId;
		this.type = type;
		this.price = price;
	}
	@Override
	public String toString() {
		return "PageRental [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", number=" + number
				+ ", status=" + status + ", money=" + money + ", op=" + op + ", searchContent=" + searchContent
				+ ", userId=" + userId + ", userImgId=" + userImgId + ", userName=" + userName + ", bicycleImgId="
				+ bicycleImgId + ", type=" + type + ", price=" + price + "]";
	}
	
}
