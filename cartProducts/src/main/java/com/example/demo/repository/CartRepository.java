package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.example.demo.model.CartItems;


@Repository
public interface CartRepository extends JpaRepository<CartItems, Integer> {
	public List<CartItems> findByUserId(int userId);
	public Optional<CartItems> findByUserIdAndProductId(int userId, int productId);
	@Modifying
	@Transactional
	public void deleteByUserId(int userId);
}
