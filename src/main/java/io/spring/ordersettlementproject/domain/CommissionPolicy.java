package io.spring.ordersettlementproject.domain;

import java.math.BigDecimal;

public class CommissionPolicy {
    private CommissionType type;     // 수수료 타입
    private BigDecimal commissionRate; // 정률 (예: 0.1 -> 10%)
    private BigDecimal commissionFee;  // 정액 (예: 500 -> 500원)
    // Getters...
}