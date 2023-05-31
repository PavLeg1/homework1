package com.train.train.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.train.Models.Flight;
import com.train.train.Repos.FlightRepo;

import jakarta.transaction.Transactional;

/**
 * The FlightService class provides methods to interact with Flight entities stored in the database.
 */
@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    /**
     * Saves a Flight entity to the database.
     * 
     * @param flight - the Flight entity to save.
     */
    public void saveFlight(Flight flight) {
        flightRepo.save(flight);
    }
    
    /**
     * Retrieves all Flight entities from the database.
     * 
     * @return a List of all Flight entities.
     */
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }
}