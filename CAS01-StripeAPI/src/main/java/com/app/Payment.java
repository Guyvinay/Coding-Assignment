package com.app;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Payment {

	 private String id;
	    private BigDecimal amount;
	    private String currency;
	
}
