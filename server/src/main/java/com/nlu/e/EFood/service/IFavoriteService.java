package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.model.FavoriteModel;

public interface IFavoriteService {
	
	Long addProductToFavorites(FavoriteModel model);

	List<ProductDTO> getAllProduct(Long accountId);
	
	boolean removeFavorite(Long accountId, Long productId);
}
