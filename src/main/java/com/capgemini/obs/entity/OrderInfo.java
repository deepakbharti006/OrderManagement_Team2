package com.capgemini.obs.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="OrderInfo")
public class OrderInfo {
	
@Id
@Column(name="order_Id")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
@SequenceGenerator(sequenceName = "order_sequence", allocationSize = 10, name = "order_seq")
private Integer orderId;

@Column(name="Quantity")
private Integer quantity;


@Column(name="SubToatl")
private Float subToatl;


@Column(name="Total")
private Float total;


@Column(name="OrderStatus")
private String orderStatus;

@NotEmpty(message = "PaymentMethod is mandatory")
@Column(name="PaymentMethod")
@Length(min=2, max=16)
private String paymentMethod;

@OneToMany(fetch=FetchType.EAGER,targetEntity = BookInfo.class, cascade = CascadeType.ALL)
@Fetch(value = FetchMode.SUBSELECT)
@JoinColumn(name = "order_Id", referencedColumnName = "order_Id")
private List<BookInfo> BookInfo;



public Integer getOrder_Id() {
	return orderId;
}

public void setOrder_Id(Integer order_Id) {
	this.orderId = order_Id;
}


public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Float getSubToatl() {
	return subToatl;
}

public void setSubToatl(Float subToatl) {
	this.subToatl = subToatl;
}

public Float getTotal() {
	return total;
}

public void setTotal(Float total) {
	this.total = total;
}

public String getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

public String getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public List<BookInfo> getBookInfo() {
	return BookInfo;
}

public void setBookInfo(List<BookInfo> bookInfo) {
	BookInfo = bookInfo;
}


@Override
public String toString() {
	return "OrderInfo [order_Id=" + orderId + ", quantity=" + quantity + ", subToatl=" + subToatl + ", total=" + total
			+ ", orderStatus=" + orderStatus + ", paymentMethod=" + paymentMethod + ", BookInfo=" + BookInfo + "]";
}



public OrderInfo(Integer order_Id, Integer quantity, Float subToatl, Float total, String orderStatus,
		@NotEmpty(message = "PaymentMethod is mandatory") @Length(min = 2, max = 16) String paymentMethod,
		List<com.capgemini.obs.entity.BookInfo> bookInfo) {
	super();
	this.orderId = order_Id;
	this.quantity = quantity;
	this.subToatl = subToatl;
	this.total = total;
	this.orderStatus = orderStatus;
	this.paymentMethod = paymentMethod;
	BookInfo = bookInfo;
}

public OrderInfo() {
	super();
	// TODO Auto-generated constructor stub
}



}
