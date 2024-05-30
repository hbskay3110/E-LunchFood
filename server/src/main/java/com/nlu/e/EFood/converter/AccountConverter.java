package com.nlu.e.EFood.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.AccountDTO;
import com.nlu.e.EFood.entity.AccountEntity;

@Component
public class AccountConverter {
	public AccountEntity toEntity(AccountDTO dto) {
		AccountEntity accEntity = new AccountEntity();
// sao chép các thuộc tính từ đối tượng dto sang entity
		BeanUtils.copyProperties(dto, accEntity);
		return accEntity;
		
	}
	// phương thức này dùng để cập nhật
	public AccountEntity toEntity(AccountDTO dto,AccountEntity entity) {
		// sao chép các thuộc tính từ đối tượng dto sang entity
		BeanUtils.copyProperties(dto, entity);
		return entity;
		
	}
	public AccountDTO toDTO(AccountEntity entity) {
		AccountDTO accDTO = new AccountDTO();
		BeanUtils.copyProperties(entity, accDTO);
		return accDTO;
	}

}
