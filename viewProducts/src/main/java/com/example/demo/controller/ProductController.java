package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService proService;
	
	@GetMapping("/products")
	public List<Product> allProducts(){
		return proService.getAllProducts();
	}
	
	@GetMapping("/products/farmer/{farmerId}")
	public List<Product> getFarmerProducts(@PathVariable int farmerId){
		return proService.getProductsByFarmer(farmerId);
	}
	
	@org.springframework.web.bind.annotation.PutMapping("/products")
	public Product updateProduct(@org.springframework.web.bind.annotation.RequestBody Product product) {
		return proService.updateProduct(product);
	}
	
	@org.springframework.web.bind.annotation.DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		proService.deleteProduct(id);
	}
}
