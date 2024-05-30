package com.nlu.e.EFood.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDto<T> {
	private Long id;
	private Date createAt;
	private List<T> listResult = new ArrayList<>();
	public BaseDto() {
        this.createAt = new Date(); // Tạo ngày giờ hiện tại khi khởi tạo đối tượng
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
	
}
