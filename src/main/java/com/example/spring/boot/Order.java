package com.example.spring.boot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oid")
	private int oid;
	
	@Column(name = "deliveryLocation")
	private String deliveryLocation;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "orderDate")
	private Date orderDate;
	
	@OrderBy("lineId")
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "order",fetch = FetchType.EAGER)
	private List<OrderLineItem> orderItems = new ArrayList<>();
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderLineItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderLineItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
