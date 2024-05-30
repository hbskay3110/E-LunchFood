package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.ChatDTO;


public interface IChatService {

	ChatDTO createAndFindChat(String firstId, String secondId);
	List<ChatDTO> findByMatchingId(String id);
	
}
