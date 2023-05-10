package com.jsti.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsti.productservice.entity.Product;
import com.jsti.productservice.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void createProduct(Product product) {
		productRepository.createProduct(product);
	}
	
	public List<Product> getAllProduct(){
		List<Product> getAllProduct =productRepository.getAllProduct();
		return getAllProduct;	
	}
	
	public Product getProductById(long id) {
		return productRepository.getProductById(id);
	}
	
	public Integer getProductQuentityById(long id) {
		return productRepository.getProductQuentiryById(id);
	}
	
	public List<Product> getProductByName(String name){
		List<Product> list = productRepository.getProductByName(name);
		return list;
	}
	
	public Product deleteProductById(long id) {
		return productRepository.deleteProductById(id);
	}
	
}
