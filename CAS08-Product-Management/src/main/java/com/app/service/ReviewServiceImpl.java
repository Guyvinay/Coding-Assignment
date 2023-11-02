package com.app.service;


import java.util.List;
import java.util.Optional;

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
//		System.out.println("From Create Review Service Impl-1");
		Product product = productRepository.findById(productId).get();
//		System.out.println("From Create Review Service Impl-2");
		review.setProduct(product);		
//		System.out.println("From Create Review Service Imp3");
		return reviewRepository.save(review);
	}

	@Override
	public Review getReviewById(Long reviewId) {
		Optional<Review> optional = reviewRepository.findById(reviewId);
		return optional.get();
	}

	@Override
	public String deleteReviewById(Long reviewId) {
		reviewRepository.deleteById(reviewId);
		return "Review Succesfully Deleted";
	}

	@Override
	public List<Review> getAllReviews() {
		List<Review> reviews = reviewRepository.findAll();
		return reviews;
	}

}
