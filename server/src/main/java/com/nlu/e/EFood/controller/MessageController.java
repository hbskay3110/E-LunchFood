package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.dto.ChatDTO;
import com.nlu.e.EFood.dto.MessageDTO;

import com.nlu.e.EFood.service.impl.MessageService;

@CrossOrigin
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@PostMapping(value = "/messages")
	public MessageDTO createMessage(@RequestBody MessageDTO messageDTO ) {
	    return messageService.createMessage(messageDTO);
	}
	@GetMapping(value = "/messages/{chatId}")
	public List<MessageDTO> findUserChat(@PathVariable("chatId") Long chatId ) {
	    return messageService.getMessages(chatId);
	}
}
