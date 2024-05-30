package com.nlu.e.EFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nlu.e.EFood.entity.ChatModelEntity;

public interface ChatRepository extends JpaRepository<ChatModelEntity, Long> {
	// Tìm kiếm cuộc trò chuyện bởi các thành viên
	@Query("SELECT c FROM ChatModelEntity c WHERE (c.firstId = :firstId AND c.secondId = :secondId) OR (c.firstId = :secondId AND c.secondId = :firstId)")
	ChatModelEntity findByMembers(String firstId, String secondId);
	// Tìm kiếm tất cả các cuộc trò truyền của user đó
	@Query("SELECT c FROM ChatModelEntity c WHERE c.firstId = :id OR c.secondId = :id")
	List<ChatModelEntity> findByUserChat(String id);
	

}

