package com.app;

import org.springframework.beans.factory.annotation.Value;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Refund;

public class StripeClient {

	@Value("${stripe.api.key}")
    private String stripeApiKey;

    public PaymentIntent createPaymentIntent(PaymentRequest paymentRequest) throws StripeException {
        // Implement Stripe API call to create a payment intent
        // Use Stripe Java SDK to make API requests

        Stripe.apiKey = stripeApiKey;

        // Create a PaymentIntent object using the Stripe API

//        return PaymentIntent.create(paymentRequest.toStripeParams());
        return null;
    }

    public PaymentIntent capturePaymentIntent(String id) throws StripeException {
        // Implement Stripe API call to capture a payment intent

        Stripe.apiKey = stripeApiKey;

        // Capture the PaymentIntent using the Stripe API

//        return PaymentIntent.retrieve(id).capture();
        return null;
    }

    public Refund createRefund(String id, RefundRequest refundRequest) throws StripeException {
        // Implement Stripe API call to create a refund

        Stripe.apiKey = stripeApiKey;

        // Create a Refund object using the Stripe API

//        return Refund.create(id, refundRequest.toStripeParams());
        return null;
    }
	
}
