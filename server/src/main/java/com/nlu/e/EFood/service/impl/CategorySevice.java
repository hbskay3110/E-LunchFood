package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.CategoryConverter;
import com.nlu.e.EFood.dto.CategoryDTO;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.entity.CategoryEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.repository.CategoryRepository;
import com.nlu.e.EFood.service.ICategoryService;

import jakarta.persistence.EntityNotFoundException;
@Service
public class CategorySevice implements ICategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryConverter categoryConverter;
	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {

		CategoryEntity entity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
//			Thực hiện việc tìm kiếm AccountEntity trong cơ sở dữ liệu
			Optional<CategoryEntity> optionalEntity = categoryRepository.findById(categoryDTO.getId());
			// Kiểm tra xem có AccountEntity được tìm thấy không
			if (optionalEntity.isPresent()) {
				// Nếu có, lấy AccountEntity từ Optional và gán vào oldAccountEntity
				CategoryEntity oldEntity = optionalEntity.get();
				// Chuyển đổi thông tin từ accDTO sang oldAccountEntity và gán vào accEntity
				entity = categoryConverter.convertToEntity(categoryDTO, oldEntity);
			} else {
				// Xử lý trường hợp không tìm thấy NewEntity với id cung cấp
				// Ví dụ: throw một exception, hoặc tạo mới một NewEntity
				throw new EntityNotFoundException("Không tìm thấy AccountEntity với id: " + categoryDTO.getId());
			}
		} else {
			// Nếu accDTO không có ID, chỉ đơn giản là chuyển đổi accDTO thành accEntity
			entity = categoryConverter.convertToEntity(categoryDTO);
		}
		// Lưu hoặc cập nhật thông tin tài khoản trong cơ sở dữ liệu
		entity = categoryRepository.save(entity);
		// Chuyển đổi đối tượng accEntity đã lưu hoặc cập nhật thành AccountDTO và trả
		// về
		return categoryConverter.convertToDTO(entity);
	}

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> listDto = new ArrayList<>();
		for (CategoryEntity entity : categoryRepository.findAll()) {
			CategoryDTO dto = categoryConverter.convertToDTO(entity) ;
		 listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {		
			Optional<CategoryEntity> optionalEntity = categoryRepository.findById(id);
			if (optionalEntity.isPresent()) {
				CategoryEntity oldEntity = optionalEntity.get();
				return categoryConverter.convertToDTO(oldEntity);
			}
			
			throw new EntityNotFoundException("Không tìm thấy AccountEntity với id: " + id);
	}
	

}
