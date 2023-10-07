package com.app;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PaymentIntent {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define fields for payment intent data
    private BigDecimal amount;
    private String currency;
    private String status;
	
}
