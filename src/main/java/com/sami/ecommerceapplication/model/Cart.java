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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
}
