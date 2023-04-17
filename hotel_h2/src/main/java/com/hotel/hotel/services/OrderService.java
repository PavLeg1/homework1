package com.hotel.hotel.services;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public Order getOrderById(Integer id) {return orderRepository.findById(id).get(); }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }




}
