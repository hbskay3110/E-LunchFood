package com.nlu.e.EFood.dto;

import java.util.Date;
import java.util.List;

public class OrderDDTO {
	private Long id;
	private String address;
	private Double totolPrice;
	private String note;
	private Integer status;
	private String name;
	private String phone;
	private Date createAt;
	private List<OrderDetailDTO> orderDetail;
	
	public OrderDDTO() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public List<OrderDetailDTO> getOrderDetail() {
		return orderDetail;
	}


	public void setOrderDetail(List<OrderDetailDTO> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	
	
	
}
