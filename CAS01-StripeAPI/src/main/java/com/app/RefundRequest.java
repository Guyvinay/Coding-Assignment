package com.app;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RefundRequest {
    private BigDecimal amount;
}
