package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.converter.CategoryConverter;
import com.nlu.e.EFood.dto.CategoryDTO;
import com.nlu.e.EFood.service.ICategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	@Autowired
	ICategoryService categoryService;
	@Autowired
	CategoryConverter categoryConverter;

	@GetMapping(value = "/categorys")
	public List<CategoryDTO> getAllProduct() {
		return categoryService.getAll();

	}
	@PostMapping(value = "/categorys")
	public CategoryDTO createAccount(@RequestBody CategoryDTO accDTO ) {
		return categoryService.save(accDTO);
	}
}
