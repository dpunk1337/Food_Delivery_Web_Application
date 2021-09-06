package com.project.BuyerBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@Column(name = "mobile_number")
	private Integer mobileNumber;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String password;
	public Buyer(Integer mobileNumber, String name, String city, String address, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.city = city;
		this.address = address;
		this.password = password;
	}
	public Buyer() {
		super();
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
