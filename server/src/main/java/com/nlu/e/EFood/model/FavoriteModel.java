package com.nlu.e.EFood.model;

public class FavoriteModel {
	private Long idAccount;
	private Long idProduct;
	
	public FavoriteModel() {
		super();
	}
	
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	
}
