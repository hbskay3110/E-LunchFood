package com.nlu.e.EFood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.e.EFood.entity.FavoriteEntity;
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
//	@Query("SELECT f FROM FavoriteEntity f WHERE f.idAccount = :idAccount")
	List<FavoriteEntity> findByAccountId(Long idAccount);
	Optional<FavoriteEntity> findByAccountIdAndProductId(Long accountId, Long productId);
}
