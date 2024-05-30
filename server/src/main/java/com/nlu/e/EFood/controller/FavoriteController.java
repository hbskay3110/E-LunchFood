package com.nlu.e.EFood.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.dto.ProductDTO;
import com.nlu.e.EFood.model.FavoriteModel;
import com.nlu.e.EFood.service.IFavoriteService;
import com.nlu.e.EFood.utils.ResponseApi;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/favorites")
public class FavoriteController {
	@Autowired
	private IFavoriteService service;
	
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseApi> create(@RequestBody FavoriteModel model) {
		Long id = service.addProductToFavorites(model);
		if (id == (long) -1) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ResponseApi("Failure", "Them vao favorites khong thanh cong, khong có account với idAccount", null));
		if (id == (long) -2) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ResponseApi("Failure", "Them vao favorites khong thanh cong, khong có product với ỉProduct", null));
		return (id != null) 
				? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Success", "Them vao faorites thanh cong", id))
				: ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ResponseApi("Failure", "Them vao faorites khong thanh cong", null));

	}
	@GetMapping(value = "/{idAccount}")
	public ResponseEntity<ResponseApi> create(@PathVariable Long idAccount) {

		List<ProductDTO> productDTOs= service.getAllProduct(idAccount);
		return (productDTOs == null)
				? ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseApi("Failure", "Khong co san pham nao", new ArrayList<>()))
				: ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Thanh Cong", productDTOs));

	}
	@DeleteMapping(value = "/remove")
    public ResponseEntity<ResponseApi> removeFavorite(@RequestParam Long idAccount, @RequestParam Long idProduct) {
        boolean isRemoved = service.removeFavorite(idAccount, idProduct);
        return isRemoved
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Success", "Xóa sản phẩm khỏi yêu thích thành công", null))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi("Failure", "Không tìm thấy sản phẩm trong yêu thích", null));
    }
}
