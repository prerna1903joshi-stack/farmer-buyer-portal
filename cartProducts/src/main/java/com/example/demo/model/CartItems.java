package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	private int userId;
	private int productId;
	private int quantity;
	private float price;
}
