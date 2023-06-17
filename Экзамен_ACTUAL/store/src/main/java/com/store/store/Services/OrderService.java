package com.store.store.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.Models.Order;
import com.store.store.Repos.OrderRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public void saveOrder(Order order){
        orderRepo.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepo.findById(id).get();
    }

    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }
    
}
