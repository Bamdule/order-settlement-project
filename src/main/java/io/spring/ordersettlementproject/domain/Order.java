
package io.spring.ordersettlementproject.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private Long id;
    private Long restaurantId;      // 가게 ID
    private BigDecimal totalPrice;      // 주문 총액 (고객 결제 금액)
    private BigDecimal discountPrice;     // 할인 금액
    private PromotionType promotionType; // 할인 주체
    private OrderStatus status;          // 주문 상태
    private LocalDate orderDate;         // 주문 일자

    public Order(Long id, Long restaurantId, BigDecimal totalPrice, BigDecimal discountPrice, PromotionType promotionType, OrderStatus status, LocalDate orderDate) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.promotionType = promotionType;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
// Getters...
}