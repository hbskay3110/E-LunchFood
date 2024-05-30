package com.nlu.e.EFood.model;

public class OrderDetailUModel {
	private Long idOrder;
	private Long idProduct;
	private Integer quantity;
	private Double price;
	public OrderDetailUModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
