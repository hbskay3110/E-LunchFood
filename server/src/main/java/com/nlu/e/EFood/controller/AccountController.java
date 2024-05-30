package com.nlu.e.EFood.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.nlu.e.EFood.converter.AccountConverter;
import com.nlu.e.EFood.dto.AccountDTO;
import com.nlu.e.EFood.dto.ChangeResponseDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.model.ChangeInforModel;
import com.nlu.e.EFood.model.ChangePassModel;
import com.nlu.e.EFood.model.LoginModel;
import com.nlu.e.EFood.service.IAccountService;

@CrossOrigin
@RestController
public class AccountController {
	@Autowired
	private IAccountService accService;
	@Autowired
	private AccountConverter accConverter;
	@PostMapping(value = "/account")
	public AccountDTO createAccount(@RequestBody AccountDTO accDTO ) {
		return accService.save(accDTO);
	}
	@GetMapping(value = "/account")
	public List<AccountDTO> createAccount() {
		return accService.findAll();
	}
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginAccount(@RequestBody LoginModel login ) {
		AccountEntity accEntity = accService.findUser(login.getEmail());
		if(accEntity == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email không tồn tại! ");
		}
		if(!login.getPassword().equals(accEntity.getPass())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password không đúng! ");
		}
		AccountDTO accDTO =  accConverter.toDTO(accEntity);
		return ResponseEntity.ok(accDTO);
	
	}
	@GetMapping(value = "/account/{id}")
	public ResponseEntity<?> getInforUser(@PathVariable("id") String id) {
		try {
			Long idLong = Long.parseLong(id);
			AccountDTO accDTO =  accConverter.toDTO(accService.findUserById(idLong));		
			return ResponseEntity.ok(accDTO);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Id không hợp lệ ");
		}	
	}
	@PutMapping(value = "/account/changePass")
	public ResponseEntity<ChangeResponseDTO> changePassAccount(@RequestBody ChangePassModel changePassModel ) {
		ChangeResponseDTO response = accService.changePassword(changePassModel);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.ok(response);
        }
	}
	@PutMapping(value = "/account/changeInfor")
	public ResponseEntity<ChangeResponseDTO> changeInforAccount(@RequestBody ChangeInforModel changePassModel ) {
		ChangeResponseDTO response = accService.changeInforUser(changePassModel);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.ok(response);
        }
	}

}
