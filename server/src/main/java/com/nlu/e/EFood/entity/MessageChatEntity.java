package com.nlu.e.EFood.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messageChat")
public class MessageChatEntity extends BaseEntity {
	@Column
	private Long chatId;
	@Column
	private Long senderId;
	@Column
	private String text;
	@Column
	private String img;
	@Column
	private Boolean status;
	
	public MessageChatEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getChatId() {
		return chatId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
