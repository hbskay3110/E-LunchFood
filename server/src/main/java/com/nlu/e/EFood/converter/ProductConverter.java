package com.nlu.e.EFood.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.repository.CategoryRepository;
import com.nlu.e.EFood.service.impl.CategorySevice;

@Component
public class ProductConverter {
	@Autowired
	DiscountConverter discountConver;
	@Autowired
	CommentConverter commentConver;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategorySevice categorySevice;
	
	
	public ProductDTO convertToDTO(ProductEntity product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setDescription(product.getDescription());
		dto.setUrlImg(product.getUrlImg());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setType(categorySevice.getCategoryById(product.getType()));
		dto.setStatus(product.getStatus());
		dto.setDiscount(discountConver.converToDTO(product.getDiscount()));
	
		return dto;
	}
	
	}


