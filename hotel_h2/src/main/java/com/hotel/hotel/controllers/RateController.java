package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Amenities;
import com.hotel.hotel.models.Level;
import com.hotel.hotel.models.Rate;
import com.hotel.hotel.services.AmenitiesService;
import com.hotel.hotel.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/rate")
public class RateController {
    @Autowired
    private RateService rateService;
    private AmenitiesService amenitiesService;

    @PostMapping("/{id}/amenities/")
    public void addAmenities(@PathVariable Integer id, @RequestBody Amenities amenities){
        Rate rate = rateService.getRateById(id);
        amenities.setRate(rate);
        amenitiesService.saveAmenities(amenities);
    }

    @GetMapping("/")
    public List<Rate> getAllRates() { return rateService.getAllRates(); }

    @GetMapping("/{id}")
    public ResponseEntity<Rate> get(@PathVariable Integer id){
        try{
            Rate rate = rateService.getRateById(id);
            return new ResponseEntity<Rate>(rate, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Rate>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ rateService.deleteRate(id); }

    @PostMapping("/")
    public void add(@RequestBody Rate rate) { rateService.saveRate(rate); }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Rate rate, @PathVariable Integer id) {
        try{
            rateService.getRateById(id);
            rate.setId(id);
            rateService.saveRate(rate);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Rate>(HttpStatus.NOT_FOUND);
        }
    }
}
