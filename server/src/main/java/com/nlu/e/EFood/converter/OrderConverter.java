package com.nlu.e.EFood.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.OrderDDTO;
import com.nlu.e.EFood.dto.OrderDTO;
import com.nlu.e.EFood.dto.OrderDetailDTO;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.OrderDetailEntity;
import com.nlu.e.EFood.entity.OrderEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.OrderDetailModel;
import com.nlu.e.EFood.model.OrderModel;
import com.nlu.e.EFood.repository.ProductRepository;
import com.nlu.e.EFood.service.impl.CategorySevice;

@Component
public class OrderConverter {
	@Autowired
	ProductRepository repository;
	@Autowired
	CategorySevice categorySevice;

	public OrderDTO convertToDTO(OrderEntity e) {
		OrderDTO dto = new OrderDTO();
		dto.setId(e.getId());
		dto.setAddress(e.getAddress());
		dto.setNote(e.getNote());
		dto.setCreateAt(e.getCreateAt());
		dto.setStatus(e.getStatus());
		dto.setTotolPrice(e.getTotolPrice());
		return dto;
	}

	public OrderEntity converterToEntity(OrderModel model) {
		OrderEntity orderE = new OrderEntity();
		orderE.setIdAccount(model.getIdAccount());
		orderE.setAddress(model.getAddress());
		orderE.setEmail(model.getEmail());
		orderE.setName(model.getName());
		orderE.setNote(model.getNote());
		orderE.setPhone(model.getPhone());
		orderE.setStatus(model.getStatus());
		orderE.setTotolPrice(model.getTotolPrice());
		orderE.setCreateAt(new Date());
		return orderE;
	}

	public OrderDetailEntity converterToOrderDetailE(OrderDetailModel model, OrderEntity orderE) {
		OrderDetailEntity ode = new OrderDetailEntity();
		ode.setProduct(Optional.of(repository.findById(model.getIdProduct())).orElse(Optional.empty()).get());
		ode.setPrice(model.getPrice());
		ode.setQuantity(model.getQuantity());
		ode.setOrder(orderE);
		return ode;

	}

	public OrderDDTO orderEConverterToOrderDDTO(OrderEntity oE) {
		OrderDDTO odDTO = new OrderDDTO();
		odDTO.setId(oE.getId());
		odDTO.setAddress(oE.getAddress());
		odDTO.setTotolPrice(oE.getTotolPrice());
		odDTO.setNote(oE.getNote());
		odDTO.setStatus(oE.getStatus());
		odDTO.setPhone(oE.getPhone());
		odDTO.setName(oE.getName());
		odDTO.setCreateAt(oE.getCreateAt());

		// lay thong tin cac order detail
		List<OrderDetailEntity> orderDetailEs = oE.getOrderDetails();
		List<OrderDetailDTO> orderDetailDTO = new ArrayList<>();

		for (OrderDetailEntity ode : orderDetailEs) {
			OrderDetailDTO orderDDTO = new OrderDetailDTO();
			orderDDTO.setIdOrderDetail(ode.getId());
			orderDDTO.setQuantity(ode.getQuantity());
			orderDDTO.setPrice(ode.getPrice());

			// lay thong tin product
			ProductEntity product = ode.getProduct();
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setDescription(product.getDescription());
			productDTO.setUrlImg(product.getUrlImg());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			productDTO.setType(categorySevice.getCategoryById(product.getType()));
			productDTO.setStatus(product.getStatus());	
			orderDDTO.setProduct(productDTO);
			orderDetailDTO.add(orderDDTO);
		}

		odDTO.setOrderDetail(orderDetailDTO);
		return odDTO;

	}

}
