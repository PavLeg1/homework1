package com.hotel.hotel.repositories;

import com.hotel.hotel.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer> {
}
