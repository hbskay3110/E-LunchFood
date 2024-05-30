package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.converter.ProductConverter;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.model.ProductPageModel;
import com.nlu.e.EFood.service.IProductService;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	IProductService productService;
	@Autowired
	ProductConverter proConverter;

	@GetMapping(value = "/products")
	public List<ProductDTO> getAllProduct() {

		return productService.getAllProduct();

	}
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String id) {
		try {
			Long idLong = Long.parseLong(id);
			ProductDTO productDto =  proConverter.convertToDTO(productService.getProductById(idLong));
			return ResponseEntity.ok(productDto);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Id không hợp lệ ");
		}
		
		
	}
	@GetMapping("/search")
    public ResponseEntity<ProductPageModel> searchProducts(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "sortDir", required = false) String sortDir) {
		Sort sort = null;
	    if (sortDir != null) {
	        sort = Sort.by(Sort.Direction.fromString(sortDir), "price");
	    }
		ProductPageModel productDTOs = productService.searchProducts(keyword, pageNo, pageSize,sort);
        return ResponseEntity.ok().body(productDTOs);
    }
}
