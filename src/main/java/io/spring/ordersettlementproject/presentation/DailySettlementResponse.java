package io.spring.ordersettlementproject.presentation;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DailySettlementResponse(
        Long restaurantId,
        LocalDate settlementDate,
        BigDecimal totalSales,
        BigDecimal commission,
        BigDecimal vat,
        BigDecimal payoutAmount
) {
}
