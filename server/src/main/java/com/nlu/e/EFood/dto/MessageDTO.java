package com.nlu.e.EFood.dto;

public class MessageDTO extends BaseDto<ChatDTO> {
	private Long chatId;
	private Long senderId;
	private String text;
	private String img;
	private Boolean status;

	public MessageDTO() {
		this.text =null;
		this.img = null;
	
	}
	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
