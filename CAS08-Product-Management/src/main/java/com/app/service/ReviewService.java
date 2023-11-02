package com.app.service;

import com.app.modal.Review;

public interface ReviewService {
	Review creatReview(Review review);
	Review getReviewById(Long reviewId);
	String deleteReviewById(Long reviewId);
}
