package com.app.service;

import java.util.List;

import com.app.modal.Product;

public interface ProductService {

	 Product createProduct(Product product);
	 Product getProductById(Long product_id);
	 List<Product> getAllProducts();
	 String deleteProductById(Long productId);
}
