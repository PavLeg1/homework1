package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Facilities;
import com.hotel.hotel.services.FacilitiesService;
import com.hotel.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {
    @Autowired
    private FacilitiesService facilitiesService;
    private RoomService roomService;

    @GetMapping("/")
    public List<Facilities> getAllFacilities() { return facilitiesService.getAllFacilities(); }

    @GetMapping("/{id}")
    public ResponseEntity<Facilities> get(@PathVariable Integer id){
        try{
            Facilities facilities = facilitiesService.getFacilitiesById(id);
            return new ResponseEntity<Facilities>(facilities, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Facilities>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ facilitiesService.deleteFacilities(id); }

    @PostMapping("/")
    public void add(@RequestBody Facilities facilities) { facilitiesService.saveFacilities(facilities); }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Facilities facilities, @PathVariable Integer id) {
        try{
            facilitiesService.getFacilitiesById(id);
            facilities.setId(id);
            facilitiesService.saveFacilities(facilities);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Facilities>(HttpStatus.NOT_FOUND);
        }
    }
}
