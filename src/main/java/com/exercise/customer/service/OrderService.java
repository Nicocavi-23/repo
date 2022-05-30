package com.exercise.customer.service;

import com.exercise.customer.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrder();
    Order findById(Long id);
    Order insert(Order order);
    boolean delete(Long id);
    Order update(Order o, Long orderId);
}
