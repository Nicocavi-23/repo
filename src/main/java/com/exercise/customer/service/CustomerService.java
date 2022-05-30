package com.exercise.customer.service;

import com.exercise.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findById(Long id);
    Customer insert(Customer customer);
    boolean delete(Long id);
    Customer update(Customer c, Long orderId);
}
