package com.app;

import java.util.List;

import com.stripe.exception.StripeException;
import com.stripe.model.Refund;

public interface PaymentService {

	    PaymentIntent createPaymentIntent(PaymentRequest paymentRequest) throws StripeException;
	    PaymentIntent capturePaymentIntent(String id) throws StripeException;
	    Refund createRefund(String id, RefundRequest refundRequest) throws StripeException;
	    List<PaymentIntent> getPaymentIntents() throws StripeException;
	
}
