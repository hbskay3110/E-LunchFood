package com.nlu.e.EFood.converter;


import org.springframework.stereotype.Component;


import com.nlu.e.EFood.dto.ChatDTO;

import com.nlu.e.EFood.entity.ChatModelEntity;

@Component
public class ChatConverter {

	public ChatDTO convertToDTO(ChatModelEntity chat) {
		ChatDTO dto = new ChatDTO();
		dto.setId(chat.getId());
		String[] member = {chat.getFirstId(),chat.getSecondId()};
		dto.setMembers(member);
		dto.setCreateAt(chat.getCreateAt());
		dto.setStatus(chat.getStatus());
		return dto;
	}
	public ChatModelEntity toEntity(ChatDTO dto, ChatModelEntity entity) {
		entity.setId(dto.getId());
		entity.setFirstId(dto.getMembers()[0]);
		entity.setSecondId(dto.getMembers()[1]);
		entity.setCreateAt(dto.getCreateAt());
		entity.setStatus(dto.getStatus());		
		return entity;
	}
	public ChatModelEntity toEntity(ChatDTO dto) {
		ChatModelEntity et = new ChatModelEntity();
		et.setId(dto.getId());
		et.setFirstId(dto.getMembers()[0]);
		et.setSecondId(dto.getMembers()[1]);
		et.setCreateAt(dto.getCreateAt());
		et.setStatus(dto.getStatus());
		return et;
	}
}
