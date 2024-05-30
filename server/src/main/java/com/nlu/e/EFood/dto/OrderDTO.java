package com.nlu.e.EFood.dto;

import java.util.Date;

public class OrderDTO {
	private Long id;
	private String address;
	private Double totolPrice;
	private String note;
	private Integer status;
	private Date createAt;
	public OrderDTO() {
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
	
}
