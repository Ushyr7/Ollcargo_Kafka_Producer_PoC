package com.ollcargo.poc.model;

public class Order {

	private int id;
	private double deliveryAmount;
	private double clientAmount;

	public Order() {		
	}
	
	public Order(int id, double deliveryAmount, double clientAmount) {
		this.id = id;
		this.deliveryAmount = deliveryAmount;
		this.clientAmount = clientAmount;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(double deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public double getClientAmount() {
		return clientAmount;
	}

	public void setClientAmount(double clientAmount) {
		this.clientAmount = clientAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "delivery_amount=" + deliveryAmount + "client_amount" + clientAmount + "]";
	}

}