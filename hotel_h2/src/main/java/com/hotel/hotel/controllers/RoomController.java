package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Facilities;
import com.hotel.hotel.models.Room;
import com.hotel.hotel.services.FacilitiesService;
import com.hotel.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    private FacilitiesService facilitiesService;

    @PostMapping("/{id}/facilities/")
    public void addFacilities(@PathVariable Integer id, @RequestBody Facilities facilities){
        Room room = roomService.getRoomById(id);
        facilities.setFacilities(facilities);
        facilitiesService.saveFacilities(facilities);
    }

    @GetMapping("/")
    public List<Room> getAllRooms() { return roomService.getAllRooms(); }

    @GetMapping("/{id}")
    public ResponseEntity<Room> get(@PathVariable Integer id){
        try{
            Room room = roomService.getRoomById(id);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ roomService.deleteRoom(id); }

    @PostMapping("/")
    public void add(@RequestBody Room room) { roomService.saveRoom(room); }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Room room, @PathVariable Integer id) {
        try{
            roomService.getRoomById(id);
            room.setId(id);
            roomService.saveRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
    }

}
