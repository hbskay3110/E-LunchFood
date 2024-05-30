package com.nlu.e.EFood.dto;

import java.util.List;

public class ChatDTO extends BaseDto<ChatDTO>{ 
	
	private String[] members ;
	private String status;
	

	
	
	public String[] getMembers() {
		return members;
	}
	public void setMembers(String[] members) {
		this.members = members;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
