package com.nlu.e.EFood.converter;

import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.CategoryDTO;
import com.nlu.e.EFood.dto.ChatDTO;
import com.nlu.e.EFood.entity.CategoryEntity;
import com.nlu.e.EFood.entity.ChatModelEntity;

@Component
public class CategoryConverter {

	public CategoryDTO convertToDTO(CategoryEntity category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setImg(category.getImg());
		dto.setName(category.getName());
		dto.setCreateAt(category.getCreateAt());
		dto.setStatus(category.getStatus());
		return dto;
	}
	public CategoryEntity convertToEntity(CategoryDTO dto) {
		CategoryEntity category = new CategoryEntity();
		category.setId(dto.getId());
		category.setImg(dto.getImg());
		category.setName(dto.getName());
		category.setCreateAt(dto.getCreateAt());
		category.setStatus(dto.getStatus());
		return category;
	}
	public CategoryEntity convertToEntity(CategoryDTO dto,CategoryEntity category) {
		category.setId(dto.getId());
		category.setImg(dto.getImg());
		category.setName(dto.getName());
		category.setCreateAt(dto.getCreateAt());
		category.setStatus(dto.getStatus());
		return category;
	}
}
