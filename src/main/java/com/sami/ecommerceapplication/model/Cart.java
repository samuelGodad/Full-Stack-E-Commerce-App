package com.sami.ecommerceapplication.model;

public class Cart extends Product{
	private  int quantity;
//	private  int total;
//	private  int id;
//	private  int user_id;
	public Cart() {

	}
	public Cart(int quantity){
		this.quantity = quantity;
	}
//	public Cart(int id, int user_id, int quantity, int total) {
//		this.id = id;
//		this.user_id = user_id;
//		this.quantity = quantity;
//		this.total = total;
//	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
}
