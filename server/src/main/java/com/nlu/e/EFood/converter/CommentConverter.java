package com.nlu.e.EFood.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.CommentDTO;
import com.nlu.e.EFood.dto.CommentImgVideoDTO;
import com.nlu.e.EFood.entity.CommentEntity;
import com.nlu.e.EFood.service.impl.AccountService;

@Component
public class CommentConverter {
	@Autowired
	CommentImgVideoConverter commentImgConver;
	@Autowired
	AccountService acService;
	@Autowired
	AccountConverter acConverter;
	public CommentDTO converToDTO(CommentEntity comment) {
		CommentDTO dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setIdProduct(comment.getIdProduct());
		dto.setAccount(acConverter.toDTO( acService.findUserById(comment.getIdAccount())) );
		dto.setContent(comment.getContent());
		dto.setRating(comment.getRating());
		dto.setCommentIVs(commentImgConver.converToListDTO(comment.getCommentIVs()));
		dto.setCreateAt(comment.getCreateAt());
		
		return dto;
		
	}
//	public CommentEntity converToEntity(CommentDTO commentDTO) {
//	
//		CommentEntity entity = new CommentEntity();
//		entity.setId(commentDTO.getId());
//		entity.setIdProduct(commentDTO.getIdProduct());
//		entity.setIdAccount(commentDTO.getIdAccount());
//		entity.setContent(commentDTO.getContent());
//		entity.setRating(commentDTO.getRating());
//		if(commentDTO.getCommentIVs() != null) {		
//			entity.setCommentIVs(commentImgConver.converToListEntity(commentDTO.getCommentIVs()));
//		}
//		entity.setCreateAt(commentDTO.getCreateAt());
//		return entity;
//		
//	}


}
