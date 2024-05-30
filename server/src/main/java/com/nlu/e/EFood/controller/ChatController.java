package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.nlu.e.EFood.dto.ChatDTO;

import com.nlu.e.EFood.model.ChatModel;

import com.nlu.e.EFood.service.IChatService;

@CrossOrigin
@RestController
public class ChatController {
	@Autowired
	private IChatService chatService;

	@PostMapping(value = "/chats")
	public ChatDTO createAccount(@RequestBody ChatModel chatDTO ) {

	    return chatService.createAndFindChat(chatDTO.getFirstId(), chatDTO.getSecondId());
	}
	
	@GetMapping(value = "/chats/{id}")
	public List<ChatDTO> findUserChat(@PathVariable("id") String id ) {

	    return chatService.findByMatchingId(id);
	}
	@GetMapping(value = "/chat/{firstId}/{secondId}")
	public ChatDTO findChat(@PathVariable("firstId") String firstId, @PathVariable("secondId") String secondId) {

	    return chatService.createAndFindChat(firstId,secondId);
	}
}
