package com.nlu.e.EFood.dto;

import java.util.Date;

public class AccountDTO extends BaseDto<AccountDTO> {
	private String email;
	private String pass;
	private String name;
	private String phone;
	private String address;
	private Date dob;
	private String urlImg;
	private Integer role;

	public AccountDTO() {
		this.name = null;
		this.phone = null;
		this.address = null;
		this.dob = null;
		this.urlImg = null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
