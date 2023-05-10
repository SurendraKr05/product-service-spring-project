package com.jsti.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsti.productservice.entity.Product;
import com.jsti.productservice.service.ProductService;
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	@PostMapping(value = "/createproduct")
	public @ResponseBody void createProduct(@RequestBody Product product)
	{
		service.createProduct(product);
	}
	
	@GetMapping(value="/getallproduct")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping(value="/getproductbyid/{productId}")
	public Product getProductById(@PathVariable("productId") long id) {
		return service.getProductById(id);
	}
	
	@GetMapping(value="/getproductquentitybyid/{productId}")
	public Integer getProductQuentityById(@PathVariable("productId") long id) {
		return service.getProductQuentityById(id);
	}
	@GetMapping("getproductbyname")
	public List<Product> getProductByName(@RequestParam("name") String name){
		return service.getProductByName(name);
	}
	@DeleteMapping("/deleteproduct/{productId}")
	public @ResponseBody Product deleteProductById(@PathVariable("productId") long id) {
		return service.deleteProductById(id);
	}
}
