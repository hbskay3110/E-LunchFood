package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.MessageConverter;
import com.nlu.e.EFood.dto.ChatDTO;
import com.nlu.e.EFood.dto.MessageDTO;
import com.nlu.e.EFood.entity.ChatModelEntity;
import com.nlu.e.EFood.entity.MessageChatEntity;
import com.nlu.e.EFood.repository.MessageRepository;
import com.nlu.e.EFood.service.IMessageService;



@Service
public class MessageService implements IMessageService{
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MessageConverter messageConverter;
	
	@Override
	public MessageDTO createMessage(MessageDTO messageDTO) {
		MessageChatEntity m = new MessageChatEntity();
		m = messageConverter.toEntity(messageDTO);
		m = messageRepository.save(m);	
		return messageConverter.convertToDTO(m);
			
		}

	@Override
	public List<MessageDTO> getMessages(Long id) {
		List<MessageChatEntity> listEntity = messageRepository.findAllByChatId(id);
		List<MessageDTO> rs = new ArrayList<>();
		for (MessageChatEntity messageEntity : listEntity) {
			rs.add(messageConverter.convertToDTO(messageEntity));		
		}
		return rs;
		
	}

}
