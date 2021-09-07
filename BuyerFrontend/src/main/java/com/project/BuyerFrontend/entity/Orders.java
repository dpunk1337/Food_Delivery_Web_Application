package com.project.BuyerFrontend.entity;

public class Orders {
	String orderId;
	String items;
	String status;
	public Orders(String orderId, String items, String status) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.status = status;
	}
	public Orders() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", items=" + items + ", status=" + status + "]";
	}
	
	
}
