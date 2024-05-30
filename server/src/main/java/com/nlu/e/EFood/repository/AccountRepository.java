package com.nlu.e.EFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.e.EFood.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	AccountEntity findByEmail(String email);


}
