package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	 
	@Autowired
	private ProductRepository proRepository;
	
	public List<Product> getAllProducts() {
		return proRepository.findAll();
	}
	
	public List<Product> getProductsByFarmer(int farmerId) {
		return proRepository.findByFarmerId(farmerId);
	}
	
	public Product updateProduct(Product product) {
		return proRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		proRepository.deleteById(id);
	}
}
