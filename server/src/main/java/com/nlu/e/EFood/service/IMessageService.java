package com.nlu.e.EFood.service;


import java.util.List;

import com.nlu.e.EFood.dto.MessageDTO;

public interface IMessageService {
	MessageDTO createMessage(MessageDTO messageDTO);
	List<MessageDTO> getMessages(Long id);
	

}
