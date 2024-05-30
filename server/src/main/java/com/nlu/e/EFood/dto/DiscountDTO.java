package com.nlu.e.EFood.dto;

public class DiscountDTO {
	private Integer discount;
	private Boolean status;

	public DiscountDTO() {
		// Default constructor
		this.discount = null;
		this.status = null;

	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
