package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Amenities;
import com.hotel.hotel.services.AmenitiesService;
import com.hotel.hotel.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/amenities")
public class AmenitiesController {
    @Autowired
    private AmenitiesService amenitiesService;
    private RateService rateService;

    // Надо ли сюда прописывать service Тарифа RateService???

    @GetMapping("")
    public List<Amenities> getAllAmenities() { return amenitiesService.getAllAmenities(); }

    @GetMapping("/{id}")
    public ResponseEntity<Amenities> get(@PathVariable Integer id){
        try{
            Amenities amenities = amenitiesService.getAmenitiesById(id);
            return new ResponseEntity<Amenities>(amenities, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Amenities>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ amenitiesService.deleteAmenities(id); }

    @PostMapping("/")
    public void add(@RequestBody Amenities amenities) { amenitiesService.saveAmenities(amenities); }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Amenities amenities, @PathVariable Integer id) {
        try{
            amenitiesService.getAmenitiesById(id);
            amenities.setId(id);
            amenitiesService.saveAmenities(amenities);
            return new ResponseEntity<>(HttpStatus.OK);
            }
        catch (NoSuchElementException e){
            return new ResponseEntity<Amenities>(HttpStatus.NOT_FOUND);
        }
    }


}
