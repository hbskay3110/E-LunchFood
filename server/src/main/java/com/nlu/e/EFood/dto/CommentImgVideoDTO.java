package com.nlu.e.EFood.dto;

public class CommentImgVideoDTO {

	private String urlImg;
	private String urlVideo;
	private Boolean status;

	public CommentImgVideoDTO() {
		// Default constructor
	
		this.urlImg = null;
		this.urlVideo = null;

	}

	// Constructor with fields
	public CommentImgVideoDTO(Long idComment, String urlImg, String urlVideo, Boolean status) {
	
		this.urlImg = urlImg;
		this.urlVideo = urlVideo;
		this.status = status;
	}

	// Getters and setters
	// Note: You can generate them automatically in most IDEs or manually like below

	

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
