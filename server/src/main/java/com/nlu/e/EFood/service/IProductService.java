package com.nlu.e.EFood.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.ProductPageModel;

public interface IProductService {
	List<ProductDTO> getAllProduct();
	ProductEntity getProductById(Long id);
	ProductPageModel  searchProducts(String keyword, int pageNo, int pageSize,Sort sort);

}
