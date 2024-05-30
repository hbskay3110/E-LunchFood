package com.nlu.e.EFood.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorites")
public class FavoriteEntity extends BaseEntity{
	// relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAccount")
	private AccountEntity account;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduct")
	private ProductEntity product;

	public FavoriteEntity() {
		// TODO Auto-generated constructor stub
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}
