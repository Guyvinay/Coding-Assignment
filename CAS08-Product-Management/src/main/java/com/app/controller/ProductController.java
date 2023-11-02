package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/createProduct")
	private ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
	}
	@GetMapping(value = "/productById/{productId}")
	private ResponseEntity<Product> createProduct(@PathVariable("productId") Long productId){
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.CREATED);
	}
	@GetMapping(value = "/allProducts")
	private ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.ACCEPTED);
	}
	@DeleteMapping(value = "/deleteProduct/{productId}")
	private ResponseEntity<String> deleteProductById(@PathVariable("productId") Long productId){
		return new ResponseEntity<String>(productService.deleteProductById(productId), HttpStatus.ACCEPTED);
	}
}
