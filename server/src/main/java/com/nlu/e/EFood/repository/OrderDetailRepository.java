package com.nlu.e.EFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nlu.e.EFood.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{
//	@Query("SELECT o FROM OrderDetailEntity o WHERE o.idOrder = :idOrder")
//	List<OrderDetailEntity> findByOrderId(@Param("idOrder") Long idOrder);
}
