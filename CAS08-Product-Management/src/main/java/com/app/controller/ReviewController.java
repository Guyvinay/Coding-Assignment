package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Review;
import com.app.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping(value = "/createReview/{productId}")
	public ResponseEntity<Review> createReview(
			@RequestBody Review review, 
			@PathVariable("productId")Long productId
			){
//		System.out.println("FROM CREATE REVIEW-1");
		Review creatReview = reviewService.creatReview(review, productId);
//		System.out.println("FROM CREATE REVIEW-2");
		return new ResponseEntity<Review>(creatReview,HttpStatus.ACCEPTED);
	}
	
}
