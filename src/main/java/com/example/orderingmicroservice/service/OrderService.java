package com.example.orderingmicroservice.service;

import com.example.orderingmicroservice.model.Order;
import com.example.orderingmicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public List<Order> getOrdersByCustomerId(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
}
