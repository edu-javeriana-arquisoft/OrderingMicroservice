package com.example.orderingmicroservice.service;

import com.example.orderingmicroservice.model.Orders;
import com.example.orderingmicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Orders> getOrderById(Long id){
        return orderRepository.findById(id);
    }
    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }
    public List<Orders> getOrdersByCustomerId(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
}
