package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.ProductConverter;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.ProductPageModel;
import com.nlu.e.EFood.repository.ProductRepository;
import com.nlu.e.EFood.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	ProductRepository productRes;
	@Autowired
	ProductConverter productConver;

	@Override
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> listDto = new ArrayList<>();
		for (ProductEntity entity : productRes.findAll()) {
		 ProductDTO dto = productConver.convertToDTO(entity) ;
		 listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public ProductEntity getProductById(Long id) {
		ProductEntity productEntity = new ProductEntity();
		Optional<ProductEntity> option = productRes.findById(id);
		if(option.isPresent()) {
			ProductEntity entity = option.get();
			productEntity = entity;
		}else {
			return null;
		}
				return productEntity;
	}
	
	@Override
	 public ProductPageModel  searchProducts(String keyword, int pageNo, int pageSize,Sort sort) {
		Pageable pageable;
	    if (sort != null) {
	        pageable = PageRequest.of(pageNo, pageSize, sort);
	    } else {
	        pageable = PageRequest.of(pageNo, pageSize);
	    }
	        Page<ProductEntity> productEntities = productRes.searchByNameOrDescription(keyword, pageable);
	        List<ProductDTO> productDTOs = productEntities.map(productConver::convertToDTO).getContent();
	        ProductPageModel productPageDTO = new ProductPageModel();
	        productPageDTO.setProducts(productDTOs);
	        productPageDTO.setTotalPages(productEntities.getTotalPages());
	        productPageDTO.setTotalElements(productEntities.getTotalElements());
	        return productPageDTO;
    }
	

}
