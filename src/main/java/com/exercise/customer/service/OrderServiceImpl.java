package com.exercise.customer.service;

import com.exercise.customer.entity.Order;
import com.exercise.customer.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class OrderServiceImpl implements OrderService{

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> findAllOrder() {
        return (List<Order>)repository.findAll();
    }

    @Override
    public Order insert(Order order) {
        return repository.save(order);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Order update(Order order, Long orderId) {

        Order ordDB = repository.findById(orderId).get();

        if (Objects.nonNull(order.getAddress()) && !"".equalsIgnoreCase(order.getAddress())){
            ordDB.setAddress(order.getAddress());
        }
        return repository.save(ordDB);
    }
}
