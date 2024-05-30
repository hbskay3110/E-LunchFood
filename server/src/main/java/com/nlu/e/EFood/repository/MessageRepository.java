package com.nlu.e.EFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.entity.MessageChatEntity;

public interface MessageRepository extends JpaRepository<MessageChatEntity, Long> {
	 List<MessageChatEntity> findAllByChatId(Long chatId);

}
