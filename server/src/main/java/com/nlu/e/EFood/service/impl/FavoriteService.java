package com.nlu.e.EFood.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nlu.e.EFood.converter.FavoriteConverter;
import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.entity.FavoriteEntity;
import com.nlu.e.EFood.entity.ProductEntity;
import com.nlu.e.EFood.model.FavoriteModel;
import com.nlu.e.EFood.repository.AccountRepository;
import com.nlu.e.EFood.repository.FavoriteRepository;
import com.nlu.e.EFood.repository.ProductRepository;
import com.nlu.e.EFood.service.IFavoriteService;

@Service
public class FavoriteService implements IFavoriteService {
	@Autowired
	private FavoriteRepository repository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private FavoriteConverter converter;

	@Override
	public Long addProductToFavorites(FavoriteModel model) {
		Optional<AccountEntity> accountE = accountRepository.findById(model.getIdAccount());
		Optional<ProductEntity> productE = productRepository.findById(model.getIdProduct());
		
		if (!accountE.isPresent()) return (long) -1;
		if (!productE.isPresent()) return (long) -2;
		
		FavoriteEntity favoriteE = converter.convertToFavoriteE(accountE.get(), productE.get());
		repository.save(favoriteE);
		
		return favoriteE.getId();
	}

	@Override
	public List<ProductDTO> getAllProduct(Long accountId) {
		List<FavoriteEntity> listFE = repository.findByAccountId(accountId);
		if(listFE.isEmpty()) return null;
		
		List<ProductDTO> listRs = new ArrayList<>();
		for (FavoriteEntity favoriteEntity : listFE) {
			ProductDTO proDTO = converter.convertToProductDTO(favoriteEntity);
			listRs.add(proDTO);
		}
		return listRs;
	}
	@Transactional
    public boolean removeFavorite(Long accountId, Long productId) {
        Optional<FavoriteEntity> favoriteEntity = repository.findByAccountIdAndProductId(accountId, productId);
        if (favoriteEntity.isPresent()) {
            repository.delete(favoriteEntity.get());
            return true;
        }
        

        return false;
    }

	

}
