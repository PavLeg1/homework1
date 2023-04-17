package com.hotel.hotel.services;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() { return roomRepository.findAll(); }

    public void saveRoom(Room room) { roomRepository.save(room); }

    public Room getRoomById(Integer id) { return roomRepository.findById(id).get(); }

    public void deleteRoom(Integer id) { roomRepository.deleteById(id); }
}

