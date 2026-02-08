package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_name")
	private String productName;

	private String category;
	private Integer quantity;
	private Float price;
	private String location;

	@jakarta.persistence.Lob
	@Column(name = "product_image", columnDefinition = "LONGTEXT")
	private String productImage;

	private String description;

	private Integer farmerId;
}
