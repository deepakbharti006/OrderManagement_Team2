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
@Table(name="CustomerInfo")
public class CustomerInfo {
	@Id
	
	@Column(name="customer_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(sequenceName = "customer_sequence", allocationSize = 100, name = "customer_seq")
	private Integer customerId;
	
	
	@NotEmpty(message = "name is mandatory")
	@Column(name="FullName")
	@Length(min=2, max=30)
	private String fullName;
	
	@NotEmpty(message = "Email is mandatory")
	@Column(name="Email")
	@Length(min=2, max=64)
	private String email ;
	
	@NotEmpty(message = "password is mandatory")
	@Column(name="password")
	@Length(min=2, max=30)
	private String password;
	
	@Column(name="PhoneNumber")
	private Long phoneNumber;
	
	@NotEmpty(message = "city name is mandatory")
	@Column(name="city")
	@Length(min=3, max=32)
	private String city;
	
	@NotEmpty(message = "Address is mandatory")
	@Column(name="Address")
	@Length(min=2, max=128)
	private String address;
	
	@NotEmpty(message = "ZipCode is mandatory")
	@Column(name="ZipCode")
	@Length(min=3, max=24)
	private String zipCode;
	
	@NotEmpty(message = "Country name is mandatory")
	@Column(name="Country")
	@Length(min=3, max=64)
	private String country;

	@OneToMany(fetch=FetchType.EAGER, targetEntity = OrderInfo.class, cascade = CascadeType.ALL)
	//@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customer_Id")
	private List<OrderInfo> OrderInfo;
	
//	@OneToMany(fetch=FetchType.EAGER,targetEntity = BookInfo.class, cascade = CascadeType.ALL)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@JoinColumn(name = "customer_Id", referencedColumnName = "customer_Id")
//	private List<BookInfo> BookInfo;



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public List<OrderInfo> getOrderInfo() {
		return OrderInfo;
	}



	public void setOrderInfo(List<OrderInfo> orderInfo) {
		OrderInfo = orderInfo;
	}



//	public List<BookInfo> getBookInfo() {
//		return BookInfo;
//	}
//
//
//
//	public void setBookInfo(List<BookInfo> bookInfo) {
//		BookInfo = bookInfo;
//	}


	


	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomerInfo(Integer customerId,
		@NotEmpty(message = "name is mandatory") @Length(min = 2, max = 30) String fullName,
		@NotEmpty(message = "Email is mandatory") @Length(min = 2, max = 64) String email,
		@NotEmpty(message = "password is mandatory") @Length(min = 2, max = 30) String password, Long phoneNumber,
		@NotEmpty(message = "city name is mandatory") @Length(min = 3, max = 32) String city,
		@NotEmpty(message = "Address is mandatory") @Length(min = 2, max = 128) String address,
		@NotEmpty(message = "ZipCode is mandatory") @Length(min = 3, max = 24) String zipCode,
		@NotEmpty(message = "Country name is mandatory") @Length(min = 3, max = 64) String country,
		List<com.capgemini.obs.entity.OrderInfo> orderInfo) {
	super();
	this.customerId = customerId;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.city = city;
	this.address = address;
	this.zipCode = zipCode;
	this.country = country;
	OrderInfo = orderInfo;
}



	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", fullName=" + fullName + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", city=" + city + ", address=" + address + ", zipCode="
				+ zipCode + ", country=" + country + ", OrderInfo=" + OrderInfo + "]";
	}

	
	
	
}