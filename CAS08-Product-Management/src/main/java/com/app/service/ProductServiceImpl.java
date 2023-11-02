package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long product_id) {
		Optional<Product> optional = productRepository.findById(product_id);
		return optional.get();
	}

	@Override
	public String deleteProductById(Long productId) {
		productRepository.deleteById(productId);
		return "SuccessFully Deleted";
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
