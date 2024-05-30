package com.nlu.e.EFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nlu.e.EFood.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	@Query("SELECT o FROM OrderEntity o WHERE o.idAccount = :idAccount")
	List<OrderEntity> findByAccountId(@Param("idAccount") Long idAccount);
}
