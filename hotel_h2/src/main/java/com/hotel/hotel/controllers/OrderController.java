package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.services.ClientService;
import com.hotel.hotel.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private ClientService clientService;


    @GetMapping("")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ orderService.deleteOrder(id); }

    @PostMapping("/")
    public void add(@RequestBody Order order) { orderService.saveOrder(order); }

    @PutMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        try{
            Order order = orderService.getOrderById(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    //@GetMapping(value="")

}
