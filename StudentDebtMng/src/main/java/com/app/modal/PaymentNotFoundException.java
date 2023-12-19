package com.app.modal;

public class PaymentNotFoundException extends RuntimeException {

	public PaymentNotFoundException(String msg) {
		super(msg);
	}
	
	public PaymentNotFoundException() {
		super("Payment Not found");
	}
	
}
