package com.nlu.e.EFood.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nlu.e.EFood.dto.DiscountDTO;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.entity.FavoriteEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.service.impl.CategorySevice;

@Component
public class FavoriteConverter {
	@Autowired
	CategorySevice categorySevice;
		public FavoriteEntity convertToFavoriteE(AccountEntity accE, ProductEntity productE) {
			FavoriteEntity favoriteE = new FavoriteEntity();
			favoriteE.setProduct(productE);
			favoriteE.setAccount(accE);
			return favoriteE;
		}
		
		public ProductDTO convertToProductDTO(FavoriteEntity favoriteE) {
			ProductDTO proDTO = new ProductDTO();
			proDTO.setId(favoriteE.getProduct().getId());
			proDTO.setDescription(favoriteE.getProduct().getDescription());
			proDTO.setName(favoriteE.getProduct().getName());
			proDTO.setPrice(favoriteE.getProduct().getPrice());
			proDTO.setStatus(favoriteE.getProduct().getStatus());
			proDTO.setType(categorySevice.getCategoryById(favoriteE.getProduct().getType()));
			proDTO.setUrlImg(favoriteE.getProduct().getUrlImg());
			DiscountDTO dDTO = new DiscountDTO();
			dDTO.setDiscount(favoriteE.getProduct().getDiscount().getDiscount());
			dDTO.setStatus(favoriteE.getProduct().getDiscount().getStatus());
			proDTO.setDiscount(dDTO);
			return proDTO;
			
		}
}
