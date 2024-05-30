package com.nlu.e.EFood.converter;

import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.MessageDTO;
import com.nlu.e.EFood.entity.MessageChatEntity;

@Component
public class MessageConverter {
	public MessageDTO convertToDTO(MessageChatEntity entity) {
			MessageDTO dto = new MessageDTO();
			dto.setId(entity.getId());
			dto.setCreateAt(entity.getCreateAt());
			dto.setChatId(entity.getChatId());
			dto.setStatus(entity.getStatus());
			dto.setImg(entity.getImg());
			dto.setSenderId(entity.getSenderId());
			dto.setText(entity.getText());
			return dto;
	}
	public MessageChatEntity toEntity(MessageDTO dto) {
		MessageChatEntity entity = new MessageChatEntity();
		entity.setId(dto.getId());
		entity.setCreateAt(dto.getCreateAt());
		entity.setChatId(dto.getChatId());
		entity.setImg(dto.getImg());
		entity.setStatus(dto.getStatus());	
		entity.setSenderId(dto.getSenderId());
		entity.setText(dto.getText());
		return entity;
	}
}
