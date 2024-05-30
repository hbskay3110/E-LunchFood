package com.nlu.e.EFood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.repository.ProductRepository;

@CrossOrigin
@RestController
public class TestController {
	@Autowired
	private ProductRepository repositoty;
	@GetMapping(value = "/productTest")
	public List<ProductEntity> getPro() {
		return repositoty.findAll();
	}
}
