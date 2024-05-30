package com.nlu.e.EFood.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nlu.e.EFood.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	@Query("SELECT p FROM ProductEntity p WHERE p.name LIKE %?1% OR p.description LIKE %?1%")
	Page<ProductEntity> searchByNameOrDescription(String keyword, Pageable pageable);

}
