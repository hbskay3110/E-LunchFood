package com.nlu.e.EFood.model;

public class OrderDetailModel {
	private Long idProduct;
	private Integer quantity;
	private Double price;
	public OrderDetailModel() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetailModel(Long idProduct, Integer quantity, Double price) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
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
