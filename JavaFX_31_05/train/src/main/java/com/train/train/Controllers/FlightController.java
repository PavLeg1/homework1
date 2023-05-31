package com.train.train.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.train.Models.Flight;
import com.train.train.Services.FlightService;

/**
 * The FlightController class provides RESTful endpoints to interact with Flight entities.
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Retrieves all Flight entities from the database.
     * 
     * @return a List of all Flight entities.
     */
    @GetMapping("/get")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    /**
     * Saves a new Flight entity to the database.
     * 
     * @param flight - the Flight entity to save.
     */
    @PostMapping("/post")
    public void addFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
    }
}