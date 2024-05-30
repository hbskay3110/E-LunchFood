package com.nlu.e.EFood.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.CommentDTO;
import com.nlu.e.EFood.dto.CommentImgVideoDTO;
import com.nlu.e.EFood.entity.CommentImgVideoEntity;

@Component
public class CommentImgVideoConverter {
	public CommentImgVideoDTO converToDTO(CommentImgVideoEntity comImg) {
		CommentImgVideoDTO dto = new CommentImgVideoDTO();
	
		dto.setUrlImg(comImg.getUrlImg());
		dto.setUrlVideo(comImg.getUrlVideo());
		dto.setStatus(comImg.getStatus());
		return dto;

	}

	public List<CommentImgVideoDTO> converToListDTO(List<CommentImgVideoEntity> comImg) {
		List<CommentImgVideoDTO> listDto = new ArrayList<>();
		for (CommentImgVideoEntity entity : comImg) {
			CommentImgVideoDTO dto = new CommentImgVideoDTO();
			dto = converToDTO(entity);
			listDto.add(dto);
		}
		return listDto;

	}

	public CommentImgVideoEntity converToEntity(CommentImgVideoDTO dto) {
		CommentImgVideoEntity entity = new CommentImgVideoEntity();
		
		entity.setUrlImg(dto.getUrlImg());
		entity.setUrlVideo(dto.getUrlVideo());
		entity.setStatus(dto.getStatus());
		return entity;
	}

	public List<CommentImgVideoEntity> converToListEntity(List<CommentImgVideoDTO> commentIVs) {
		List<CommentImgVideoEntity> listEntity = new ArrayList<>();
		for (CommentImgVideoDTO dto : commentIVs) {
			CommentImgVideoEntity entity = new CommentImgVideoEntity();
			entity = converToEntity(dto);
			listEntity.add(entity);

		}
		return listEntity;
	}

}
