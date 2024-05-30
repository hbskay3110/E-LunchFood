package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nlu.e.EFood.converter.OrderConverter;
import com.nlu.e.EFood.dto.OrderDDTO;
import com.nlu.e.EFood.dto.OrderDTO;
import com.nlu.e.EFood.entity.OrderDetailEntity;
import com.nlu.e.EFood.entity.OrderEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.OrderDetailModel;
import com.nlu.e.EFood.model.OrderDetailUModel;
import com.nlu.e.EFood.model.OrderModel;
import com.nlu.e.EFood.model.OrderUModel;
import com.nlu.e.EFood.repository.OrderDetailRepository;
import com.nlu.e.EFood.repository.OrderRepository;
import com.nlu.e.EFood.repository.ProductRepository;
import com.nlu.e.EFood.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderConverter converter;

	@Override
	public List<OrderDTO> getAllOrder() {
		List<OrderEntity> orderEs = repository.findAll();

		// kiem tra co order khong
		if (orderEs.size() < 1)
			return null;

		// convert orderE sang dto
		List<OrderDTO> orderRs = new ArrayList<>();
		for (OrderEntity orderEntity : orderEs) {
			orderRs.add(converter.convertToDTO(orderEntity));
		}
		return orderRs;
	}

	public List<OrderDTO> getOrderByAccountId(Long idAccount) {
		// lay don hang theo id account
		List<OrderEntity> orderEs = repository.findByAccountId(idAccount);
		if (orderEs.size() < 1)
			return null;
		// convert orderE sang dto
		List<OrderDTO> orderRs = new ArrayList<>();
		for (OrderEntity orderEntity : orderEs) {
			orderRs.add(converter.convertToDTO(orderEntity));
		}
		return orderRs;
	}

	@Override
	public OrderDDTO getOrderById(Long id) {
		// lay don hang theo id account
		Optional<OrderEntity> orderE = repository.findById(id);
		if (orderE.isEmpty())
			return null;
		// lay thong tin order
		OrderEntity oEntity = orderE.get();

		OrderDDTO odDTO = converter.orderEConverterToOrderDDTO(oEntity);
		return odDTO;
	}

	@Transactional
	@Override
	public Long createOrder(OrderModel model) {
		// convert model sang OrderEntity
		OrderEntity orderE = converter.converterToEntity(model);
		// luu db
		repository.save(orderE);

		// lưu orderDetail

		for (OrderDetailModel odm : model.getOrderDetails()) {
			orderDetailRepository.save(converter.converterToOrderDetailE(odm, orderE));
		}

		return orderE.getId();
	}

	@Transactional
	@Override
	public int updateOrder(Long id, OrderUModel model) {
		try {
			// kiem tra co ton tai don hang
			Optional<OrderEntity> orderEntity = repository.findById(id);
			if (!orderEntity.isPresent()) {
				return -1;
			}

			// Lây entity tu optional
			OrderEntity odE = orderEntity.get();

			// update thong tin
			odE.setId(id);
			odE.setEmail(model.getEmail());
			odE.setName(model.getName());
			odE.setAddress(model.getAddress());
			odE.setTotolPrice(model.getTotolPrice());
			odE.setPhone(model.getPhone());
			odE.setNote(model.getNote());
			odE.setStatus(model.getStatus());

			// luu
			repository.save(odE);

			// update orderDetail
			for (OrderDetailUModel odm : model.getOrderDetails()) {
				Optional<OrderDetailEntity> orderDEntity = orderDetailRepository.findById(odm.getIdOrder());
				if (!orderDEntity.isPresent())
					return -2;

				OrderDetailEntity odde = orderDEntity.get();
				odde.setPrice(odm.getPrice());
				odde.setQuantity(odm.getQuantity());
				// cap nhat product

				Optional<ProductEntity> proEntity = productRepository.findById(odm.getIdProduct());
				if (!proEntity.isPresent())
					return -3;

				ProductEntity proE = proEntity.get();
				odde.setProduct(proE);

				// luu
				orderDetailRepository.save(odde);
			}

			return 1;
		} catch (Exception e) {
			// Xảy ra lỗi trong quá trình cập nhật
			return -4; 
		}
	}

}
