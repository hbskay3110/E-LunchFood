package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.CategoryDTO;

public interface ICategoryService {
	CategoryDTO save(CategoryDTO categoryDTO);
	List<CategoryDTO> getAll();
	CategoryDTO getCategoryById(Long id);
}
