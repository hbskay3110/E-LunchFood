package com.nlu.e.EFood.converter;

import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.DiscountDTO;
import com.nlu.e.EFood.entity.DiscountEntity;

@Component
public class DiscountConverter {
	public DiscountDTO converToDTO(DiscountEntity discount) {
		  if (discount == null) {
		        return null; //
		    }
		DiscountDTO dto = new DiscountDTO();
		dto.setDiscount(discount.getDiscount());
		dto.setStatus(discount.getStatus());
		return dto;
		
	}


}
