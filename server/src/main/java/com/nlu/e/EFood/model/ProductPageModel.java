package com.nlu.e.EFood.model;

import java.util.List;

import com.nlu.e.EFood.dto.ProductDTO;

public class ProductPageModel {
    private List<ProductDTO> products;
    private int totalPages;
    private long totalElements;
	public ProductPageModel(List<ProductDTO> products, int totalPages, long totalElements) {
		super();
		this.products = products;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}
	public ProductPageModel() {
		
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

    
    
}
