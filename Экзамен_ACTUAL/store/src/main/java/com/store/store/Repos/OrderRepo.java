package com.store.store.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.Models.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {}
