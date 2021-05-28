package com.berec.prf.spring.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
	@SequenceGenerator(name = "transaction_generator", sequenceName = "transaction_seq", allocationSize = 1)
	@Column(name = "transaction_id")
	private int transaction_id;

	@Column(name = "date_of_purchase")
	private Date date_of_purchase;

	@Column(name = "purchase_id")
	private int purchase_id;

	@Column(name = "price")
	private int price;

	public Transaction() {
	}

	public Transaction(int transaction_id, Date date_of_purchase, int purchase_id, int price) {
		this.transaction_id = transaction_id;
		this.date_of_purchase = date_of_purchase;
		this.purchase_id = purchase_id;
		this.price = price;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getDate_of_purchase() {
		return date_of_purchase;
	}

	public void setDate_of_purchase(Date date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", date_of_purchase=" + date_of_purchase
				+ ", purchase_id=" + purchase_id + ", price=" + price + "]";
	}
}
