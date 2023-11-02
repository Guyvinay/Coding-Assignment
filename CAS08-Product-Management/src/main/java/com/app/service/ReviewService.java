package com.app.service;

import java.util.List;

import com.app.modal.Review;

public interface ReviewService {
	Review creatReview(Review review, Long productId);
	Review getReviewById(Long reviewId);
	List<Review> getAllReviews();
	String deleteReviewById(Long reviewId);
}
