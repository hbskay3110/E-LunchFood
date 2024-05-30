package com.nlu.e.EFood.model;

import java.util.ArrayList;
import java.util.List;

import com.nlu.e.EFood.dto.CommentImgVideoDTO;

public class CommentModel  {
	private Long idProduct;
	private Long idAccount;
	private String content;
	private Integer rating;
	private List<CommentImgVideoDTO> commentIVs;


	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
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
		return "CommentDTO [idProduct=" + idProduct + ", idAccount=" + idAccount + ", content=" + content + ", rating="
				+ rating + ", commentIVs=" + commentIVs + "]";
	}
	
}
