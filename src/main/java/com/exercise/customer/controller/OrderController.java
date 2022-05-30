package com.exercise.customer.controller;

import com.exercise.customer.entity.Order;
import com.exercise.customer.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<Order> getAllPeople() {
        return orderService.findAllOrder();
    }

    @GetMapping("{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping("")
    public String insert(@Valid @RequestBody Order order) {

        if(order != null) {
            orderService.insert(order);
            return "Added an order";
        } else {
            return "Request does not contain a body";
        }

    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable("id") Long id) {

        if(id > 0) {
            if(orderService.delete(id)) {
                return "Deleted the order.";
            } else {
                return "Cannot delete the order.";
            }
        }
        return "The id is invalid for the order.";
    }

    @PutMapping("{id}")
    public String updateOrder(@RequestBody Order order, @PathVariable("id") Long orderId) {
        if(order != null) {
            orderService.update(order, orderId);
            return "Updated order.";
        } else {
            return "Request does not contain a body";
        }
    }
}
