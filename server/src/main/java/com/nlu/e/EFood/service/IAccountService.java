package com.nlu.e.EFood.service;

import java.util.List;

import com.nlu.e.EFood.dto.AccountDTO;
import com.nlu.e.EFood.dto.ChangeResponseDTO;
import com.nlu.e.EFood.entity.AccountEntity;
import com.nlu.e.EFood.model.ChangeInforModel;
import com.nlu.e.EFood.model.ChangePassModel;


public interface IAccountService {
	AccountDTO save(AccountDTO accDTO);
	void delete(long[] ids);
	List<AccountDTO> findAll();
    AccountEntity findUser(String email);
	int totalItem();
	AccountEntity findUserById(Long id);
	ChangeResponseDTO changePassword(ChangePassModel changePassModel);
	ChangeResponseDTO changeInforUser(ChangeInforModel changeInforModel);

}
