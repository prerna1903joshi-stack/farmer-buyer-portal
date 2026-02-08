package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.example.demo.model.CartItems;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public CartItems addToCart(int userId, int productId, float price) {
		Optional<CartItems> existingItem = cartRepository.findByUserIdAndProductId(userId, productId);
		if (existingItem.isPresent()) {
			CartItems item = existingItem.get();
			item.setQuantity(item.getQuantity() + 1);
			return cartRepository.save(item);
		}
		CartItems newItem = new CartItems();
		newItem.setUserId(userId);
		newItem.setProductId(productId);
		newItem.setQuantity(1);
		newItem.setPrice(price);

		return cartRepository.save(newItem);
	}

	public List<CartItems> getAllItems(int userId) {
		return cartRepository.findByUserId(userId);
	}

	public CartItems updateQuantity(int cartItemId, int quantity) {
		CartItems item = cartRepository.findById(cartItemId)
				.orElseThrow(() -> new RuntimeException("Cart item not found"));

		item.setQuantity(quantity);
		return cartRepository.save(item);
	}

	public void removeItem(int cartItemId) {
		cartRepository.deleteById(cartItemId);
	}

	public void clearCart(int userId) {
		List<CartItems> items = cartRepository.findByUserId(userId);
		cartRepository.deleteAll(items);
	}
	
	public void deleteItem(int cartItemId) {
	    cartRepository.deleteById(cartItemId);
	}
	
	@Transactional
	public void deleteByUserId(int userId) {
		cartRepository.deleteByUserId(userId);
	}

}
