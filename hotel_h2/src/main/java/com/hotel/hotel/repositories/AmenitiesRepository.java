package com.hotel.hotel.repositories;

import com.hotel.hotel.models.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
}
