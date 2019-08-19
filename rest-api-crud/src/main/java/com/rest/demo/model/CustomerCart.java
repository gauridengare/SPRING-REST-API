package com.rest.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_cart")
public class CustomerCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course")
	private String course;
	
	@Column(name="unitPrice")
	private int unitPrice;
	
	@Column(name="totalPrice")
	private int totalPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="userId")
	private int userId;
	
	public CustomerCart()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CustomerCart [course=" + course + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", quantity=" + quantity + ", userId=" + userId + "]";
	}
	
	
	
}
