package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.OrderDTO;
import com.nlu.e.EFood.dto.OrderDDTO;
import com.nlu.e.EFood.entity.OrderDetailEntity;
import com.nlu.e.EFood.model.OrderDetailModel;
import com.nlu.e.EFood.model.OrderModel;
import com.nlu.e.EFood.model.OrderUModel;

public interface IOrderService {
	public List<OrderDTO> getAllOrder();
	public List<OrderDTO> getOrderByAccountId(Long idAccount);
	public OrderDDTO getOrderById(Long id);
	public Long createOrder(OrderModel model);
	public int updateOrder(Long id, OrderUModel model);
}
