package com.brs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Bicycle implements Serializable{
	private String bicId;
	private String type;
	private int price;
	private Imgs imgs;
	private int status;
	private Set<Rental> rental = new HashSet<Rental>();
	public String getBicId() {
		return bicId;
	}
	public void setBicId(String bicId) {
		this.bicId = bicId;
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
	public Imgs getImgs() {
		return imgs;
	}
	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Bicycle() {
		super();
	}
	public Set<Rental> getRental() {
		return rental;
	}
	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}
	public Bicycle(String bicId, String type, int price, Imgs imgs, int status, Set<Rental> rental) {
		super();
		this.bicId = bicId;
		this.type = type;
		this.price = price;
		this.imgs = imgs;
		this.status = status;
		this.rental = rental;
	}
	@Override
	public String toString() {
		return "Bicycle [bicId=" + bicId + ", type=" + type + ", price=" + price + ", imgs=" + imgs + ", status="
				+ status + "]";
	}
	
}
