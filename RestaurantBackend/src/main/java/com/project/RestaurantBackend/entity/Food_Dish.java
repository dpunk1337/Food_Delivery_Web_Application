package com.project.RestaurantBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_dish")
public class Food_Dish {
	
	
	@Column(name="dish_id")
	private String id;
	@Id
	@Column
	private Integer mobile_number;
	@Column
	private Integer price;
	@Column
	private String name;
	
	public Food_Dish(String id, Integer mobile_number, Integer price, String name) {
		super();
		this.id = id;
		this.mobile_number = mobile_number;
		this.price = price;
		this.name = name;
	}
	public Food_Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Integer mobile_number) {
		this.mobile_number = mobile_number;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
