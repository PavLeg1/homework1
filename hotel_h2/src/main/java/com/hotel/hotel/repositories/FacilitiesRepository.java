package com.hotel.hotel.repositories;

import com.hotel.hotel.models.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {
}
