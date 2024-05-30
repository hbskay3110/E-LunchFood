package com.nlu.e.EFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.e.EFood.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findAllByIdProduct(Long idProduct);

}
