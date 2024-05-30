package com.nlu.e.EFood.dto;

import java.util.ArrayList;
import java.util.List;

public class CommentDTO extends BaseDto<CommentDTO> {
	private Long idProduct;
	private AccountDTO account;
	private String content;
	private Integer rating;
	private List<CommentImgVideoDTO> commentIVs;


	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<CommentImgVideoDTO> getCommentIVs() {
		return commentIVs;
	}

	public void setCommentIVs(List<CommentImgVideoDTO> commentIVs) {
		this.commentIVs = commentIVs;
	}


	@Override
	public String toString() {
		return "CommentDTO [idProduct=" + idProduct + ", idAccount=" + account.toString() + ", content=" + content + ", rating="
				+ rating + ", commentIVs=" + commentIVs + "]";
	}
	
}
