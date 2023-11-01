package com.app.service;

import com.app.modal.Product;

public interface ProductService {

	 Product createProduct(Product product);
	 Product getProductById(Long product_id);
}
