package com.nlu.e.EFood.dto;

public class OrderDetailDTO {
	private Long idOrderDetail;
	private Integer quantity;
	private Double price;
	private ProductDTO product;
	
	public OrderDetailDTO() {
		super();
	}

	public Long getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(Long idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	
}
