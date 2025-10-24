package io.spring.ordersettlementproject.repository;

import io.spring.ordersettlementproject.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant findById(Long id);
    List<Restaurant> findAll();
}