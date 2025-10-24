package io.spring.ordersettlementproject.repository;

import io.spring.ordersettlementproject.domain.Order;
import io.spring.ordersettlementproject.domain.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {
    // 특정 가게의 특정 날짜에 완료된 주문 목록
    List<Order> findByRestaurantIdAndOrderDateAndStatus(
            Long restaurantId, LocalDate date, OrderStatus status
    );
    
    // (3번 문제용) 특정 날짜에 완료된 모든 주문
    List<Order> findByOrderDateAndStatus(LocalDate date, OrderStatus status);
}