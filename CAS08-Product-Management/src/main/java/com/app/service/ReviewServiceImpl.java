package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Product;
import com.app.modal.Review;
import com.app.repository.ProductRepository;
import com.app.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Review creatReview(Review review, Long productId) {
		System.out.println("From Create Review Service Impl");
		Product product = productRepository.findById(productId).get();
		review.setProduct(product);		
		return reviewRepository.save(review);
	}

	@Override
	public Review getReviewById(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteReviewById(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

}
