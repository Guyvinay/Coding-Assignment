package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.modal.Payment;

public interface PaymentService {
	
	public Map<String, Object> addPayment(String student_id,  Payment payment);
	public Payment getPaymentById(String _id);
	public List<Payment> getAllPayments();

}
