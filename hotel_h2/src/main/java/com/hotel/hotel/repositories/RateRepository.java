package com.hotel.hotel.repositories;

import com.hotel.hotel.models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Integer> {
}
