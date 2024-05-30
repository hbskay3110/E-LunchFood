package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.e.EFood.converter.CommentConverter;
import com.nlu.e.EFood.converter.CommentImgVideoConverter;
import com.nlu.e.EFood.dto.CommentDTO;
import com.nlu.e.EFood.dto.CommentImgVideoDTO;
import com.nlu.e.EFood.entity.CommentEntity;
import com.nlu.e.EFood.entity.CommentImgVideoEntity;
import com.nlu.e.EFood.model.CommentModel;
import com.nlu.e.EFood.repository.CommentRepository;
import com.nlu.e.EFood.service.ICommentService;

@Service
public class CommentService implements ICommentService {
	@Autowired
	CommentConverter converter;
	@Autowired
	CommentImgVideoConverter converterVideoConverter;
	@Autowired
	CommentRepository repository;

	@Override
	public CommentDTO createComment(CommentModel commentModel) {
		CommentEntity et = new CommentEntity();
		et.setContent(commentModel.getContent());
		List<CommentImgVideoEntity> l = new ArrayList<>();
		if(commentModel.getCommentIVs() != null)
		for (CommentImgVideoDTO dto : commentModel.getCommentIVs()) {
			l.add(converterVideoConverter.converToEntity(dto));
		}
		et.setCommentIVs(l);
		et.setCreateAt(new Date());
		et.setIdAccount(commentModel.getIdAccount());
		et.setIdProduct(commentModel.getIdAccount());

		repository.save(et);
		return converter.converToDTO(et);
	}

	@Override
	public List<CommentDTO> getCommentByProduct(Long idProduct) {
		List<CommentEntity> entity = repository.findAllByIdProduct(idProduct);
		List<CommentDTO> dto = new ArrayList<>();
		  for (CommentEntity commentEntity : entity) {
			dto.add(converter.converToDTO(commentEntity));
		}
		return dto ;
	}

}
