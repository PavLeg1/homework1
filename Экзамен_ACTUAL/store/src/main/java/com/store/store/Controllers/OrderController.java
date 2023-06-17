package com.store.store.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.store.Models.Order;
import com.store.store.Services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public void save(@RequestBody Order order){
        orderService.saveOrder(order);
    }

    @GetMapping("")
    public List<Order> getAll(){
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            Order order =orderService.getOrderById(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long id){
        try{
            Order _order = orderService.getOrderById(id);
            _order.updateOrder(order);
            orderService.saveOrder(_order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
