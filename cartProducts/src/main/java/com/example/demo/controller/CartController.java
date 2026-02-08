package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CartItems;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE, org.springframework.web.bind.annotation.RequestMethod.OPTIONS})
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/items/{userId}/{productId}")
	public CartItems addToCart(@PathVariable int userId,@PathVariable int productId,@RequestParam float price) {
	    return cartService.addToCart(userId, productId, price);
	}
	
	@GetMapping("/items/{id}")
	public List<CartItems> allItems(@PathVariable ("id") int userId) {
		return cartService.getAllItems(userId);
	}
	
	@PutMapping("/items/{cartId}")
	public CartItems updateQuantity(@PathVariable int cartId,@RequestParam int quantity) {
		return cartService.updateQuantity(cartId, quantity);
	}
	
	@DeleteMapping("/items/{userId}")
    public void clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
    }
	
	@DeleteMapping("/items/cart/{cartItemId}")
	public void removeCartItem(@PathVariable int cartItemId) {
	    cartService.removeItem(cartItemId);
	}

	@DeleteMapping("/items/user/{userId}")
	public void clearCartByUser(@PathVariable int userId) {
	    cartService.deleteByUserId(userId);
	}

}
