package com.ollcargo.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders", schema = "public")
public class Order {

	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="delivery_amount")
	private double deliveryAmount;
	@Column(name="client_amount")
	private double clientAmount;

	public Order() {		
	}
	
	public Order(int id, double deliveryAmount, double clientAmount) {
		this.id = id;
		this.deliveryAmount = deliveryAmount;
		this.clientAmount = clientAmount;
	}
	
	@Id
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