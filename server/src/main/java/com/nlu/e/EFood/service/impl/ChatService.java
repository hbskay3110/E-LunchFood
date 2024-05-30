package com.nlu.e.EFood.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.ChatConverter;
import com.nlu.e.EFood.dto.ChatDTO;
import com.nlu.e.EFood.entity.ChatModelEntity;
import com.nlu.e.EFood.repository.ChatRepository;
import com.nlu.e.EFood.service.IChatService;
@Service
public class ChatService implements IChatService{

	 @Autowired
	 private ChatRepository chatRepository;
	 @Autowired
	 private ChatConverter chatConverter;
	@Override
	public ChatDTO createAndFindChat(String firstId, String secondId) {
		// Kiểm tra xem cuộc trò chuyện đã tồn tại chưa
        ChatModelEntity chat = chatRepository.findByMembers(firstId, secondId);
        if (chat != null) {
            return chatConverter.convertToDTO(chat);
        }
//      Nếu cuộc trò chuyện chưa tồn tại, tạo mới và lưu vào cơ sở dữ liệu
         chat = new ChatModelEntity();
        chat.setSecondId(secondId);
        chat.setFirstId(firstId);
        chat.setCreateAt(new Date());
        chat = chatRepository.save(chat);
        return chatConverter.convertToDTO(chat);
		
	}
	@Override
	public List<ChatDTO> findByMatchingId(String id) {
		List<ChatModelEntity> listEntity = chatRepository.findByUserChat(id);
		List<ChatDTO> rs = new ArrayList<>();
		for (ChatModelEntity chatModelEntity : listEntity) {
			rs.add(chatConverter.convertToDTO(chatModelEntity));		
		}
		return rs;
	}

}
