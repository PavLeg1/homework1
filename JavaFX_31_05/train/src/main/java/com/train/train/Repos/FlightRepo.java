package com.train.train.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.train.Models.Flight;

/**
 * The FlightRepo interface extends JpaRepository and provides additional methods to interact with Flight entities stored in the database.
 */
public interface FlightRepo extends JpaRepository<Flight, Long>{
    
}