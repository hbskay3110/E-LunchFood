package com.nlu.e.EFood.controller;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.dto.OrderDDTO;
import com.nlu.e.EFood.dto.OrderDTO;
import com.nlu.e.EFood.model.OrderModel;
import com.nlu.e.EFood.model.OrderUModel;
import com.nlu.e.EFood.service.IOrderService;
import com.nlu.e.EFood.utils.ResponseApi;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderController {
	@Autowired
	private IOrderService service;

	@GetMapping(value = "/")
	public ResponseEntity<ResponseApi> getOrders() {
		List<OrderDTO> dtos = service.getAllOrder();
		return (dtos == null)
				? ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseApi("Failure", "Khong co don hang nao", new ArrayList<>()))
				: ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Thanh Cong", dtos));

	}

	@GetMapping(value = "/account/{idAccount}")
	public ResponseEntity<ResponseApi> getOrdersByAccountId(@PathVariable Long idAccount) {
		List<OrderDTO> dtos = service.getOrderByAccountId(idAccount);
		return (dtos == null)
				? ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseApi("Failure", "Khong co don hang nao", new ArrayList<>()))
				: ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Thanh Cong", dtos));

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseApi> getOrdersById(@PathVariable Long id) {
		OrderDDTO dto = service.getOrderById(id);
		return (dto == null)
				? ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseApi("Failure", "Khong tim thay don hang", null))
				: ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Thanh Cong", dto));

	}

	@PostMapping(value = "/create")
	public ResponseEntity<ResponseApi> create(@RequestBody OrderModel model) {
		Long id = service.createOrder(model);
		return (id != null) 
				? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Success", "Tao don hang thanh cong", id))
				: ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ResponseApi("Failure", "tạo don hang khong thanh cong", null));

	}
	

    @PutMapping("/update/{orderId}")
    public ResponseEntity<ResponseApi> updateOrder(@PathVariable Long orderId, @RequestBody OrderUModel model) {
    	int rs = service.updateOrder(orderId, model);
    	switch (rs) {
		case -1: 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi("Failure", "Khong tim thay don hang", rs));
		case -2: 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi("Failure", "Khong tim thay don hang chi tiet", rs));
		case -3: 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi("Failure", "Khong tim thay product", rs));
		case -4: 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseApi("Failure", "Tao don hang thanh cong", rs));
		}
    	return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Update don hang thanh cong", rs));
    }

}
