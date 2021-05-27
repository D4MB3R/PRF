package com.berec.prf.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchase_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private int price;

	public Purchase(int id, String name, int price) {
		this.purchase_id = id;
		this.name = name;
		this.price = price;
	}

	public Purchase() {
	}

	public int getId() {
		return purchase_id;
	}

	public void setId(int id) {
		this.purchase_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + purchase_id + ", name=" + name + ", price=" + price + "]";
	}
}
