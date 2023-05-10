package com.jsti.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Product {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="product_id")
	private long productId;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="discription")
	private String discription;
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", discription=" + discription + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
