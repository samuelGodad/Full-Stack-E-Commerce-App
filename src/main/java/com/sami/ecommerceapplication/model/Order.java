package com.sami.ecommerceapplication.model;
import java.sql.Timestamp;

public class Order  extends  Product {
	private int quantity;
	private int orderId;
	private Timestamp date;
	private int user_id;

	public Order() {

	}

	public Order(int quantity, int orderId, Timestamp date, int user_id) {
		this.quantity = quantity;
		this.orderId = orderId;
		this.date = date;
		this.user_id = user_id;

	}

	public Order(int quantity, Timestamp date, int user_id) {
		this.quantity = quantity;
		this.date = date;
		this.user_id = user_id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;

	}
	public int getOrderId() {
		return orderId;
	}
	public void setDate(Timestamp date) {
		this.date = date;

	}
	public Timestamp getDate() {
		return date;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;

	}
	public int getUser_id() {
		return user_id;
	}
	@Override
	public String toString() {
		return "Order{" +
				"quantity=" + quantity +
				", orderId=" + orderId +
				", date='" + date + '\'' +
				", user_id=" + user_id +
				'}';
	}
}