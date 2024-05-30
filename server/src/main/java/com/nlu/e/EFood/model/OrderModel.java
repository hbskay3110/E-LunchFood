package com.nlu.e.EFood.model;

import java.util.List;

public class OrderModel {
	private Long idAccount;
	private String email;
	private String name;
	private String address;
	private Double totolPrice;
	private String phone;
	private String note;
	private Integer status;
	private List<OrderDetailModel> orderDetails;

	public OrderModel() {
		// TODO Auto-generated constructor stub
	}

	public OrderModel(Long idAccount, String email, String name, String address, Double totolPrice, String phone,
			String note, Integer status, List<OrderDetailModel> orderDetails) {
		super();
		this.idAccount = idAccount;
		this.email = email;
		this.name = name;
		this.address = address;
		this.totolPrice = totolPrice;
		this.phone = phone;
		this.note = note;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getTotolPrice() {
		return totolPrice;
	}

	public void setTotolPrice(Double totolPrice) {
		this.totolPrice = totolPrice;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<OrderDetailModel> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailModel> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
