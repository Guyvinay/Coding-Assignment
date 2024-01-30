package com.app.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping(value = "/students/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = "/{student_id}")
	public ResponseEntity<Map<String, Object>> addPayment(
			@PathVariable("student_id") String student_id,
			@Valid @RequestBody Payment payment){
		return new ResponseEntity<Map<String,Object>>(
				paymentService.addPayment(student_id, payment),
				HttpStatus.ACCEPTED
				);
	}
	
	@GetMapping(value = "/{_id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("_id") String _id){
		return new ResponseEntity<Payment>(
				paymentService.getPaymentById(_id),
				HttpStatus.ACCEPTED
				);
	}
	
	@GetMapping()
	public ResponseEntity<List<Payment>> getAllPayments(){
		return new ResponseEntity<List<Payment>>(
				paymentService.getAllPayments(),
				HttpStatus.ACCEPTED
				);
	}
}
