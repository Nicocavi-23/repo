package com.exercise.customer.controller;

import com.exercise.customer.entity.Customer;
import com.exercise.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> getAllPeople() {
        return customerService.findAllCustomer();
    }

    @GetMapping("{id}")
    public Customer getOrder(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping("")
    public String insert(@Valid @RequestBody Customer customer) {

        if(customer != null) {
            customerService.insert(customer);
            return "Added an customer";
        } else {
            return "Request does not contain a body";
        }

    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable("id") Long id) {

        if(id > 0) {
            if(customerService.delete(id)) {
                return "Deleted the order.";
            } else {
                return "Cannot delete the customer.";
            }
        }
        return "The id is invalid for the customer.";
    }

    @PutMapping("{id}")
    public String updateOrder(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
        if(customer != null) {
            customerService.update(customer, customerId);
            return "Updated customer.";
        } else {
            return "Request does not contain a body";
        }
    }
}
