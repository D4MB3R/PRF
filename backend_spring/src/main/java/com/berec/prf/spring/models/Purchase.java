package com.berec.prf.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_generator")
	@SequenceGenerator(name = "purchase_generator", sequenceName = "purchase_seq", allocationSize = 1)
	@Column(name = "purchase_id")
	private int purchase_id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private int price;

	public Purchase() {
	}

	public Purchase(int purchase_id, String name, int price) {
		this.purchase_id = purchase_id;
		this.name = name;
		this.price = price;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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
		return "Purchase [purchase_id=" + purchase_id + ", name=" + name + ", price=" + price + "]";
	}
}
