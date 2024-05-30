package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.dto.CommentDTO;
import com.nlu.e.EFood.model.CommentModel;
import com.nlu.e.EFood.service.impl.CommentService;



@CrossOrigin
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@PostMapping(value = "/comments")
	public CommentDTO createComment(@RequestBody CommentModel commentDto) {
		return commentService.createComment(commentDto);	
	}
	
	@GetMapping(value = "/comments/{idProduct}")
	public List<CommentDTO> findAllByIdPProduct(@PathVariable("idProduct") Long idProduct){
		return commentService.getCommentByProduct(idProduct);
		
	}

}