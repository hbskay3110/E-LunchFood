package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.CommentDTO;
import com.nlu.e.EFood.model.CommentModel;

public interface ICommentService {
	CommentDTO createComment(CommentModel commentModel);
	List<CommentDTO> getCommentByProduct(Long idProduct);

}
