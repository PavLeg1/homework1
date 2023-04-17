package com.hotel.hotel.services;

import com.hotel.hotel.models.Amenities;
import com.hotel.hotel.repositories.AmenitiesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AmenitiesService {
    @Autowired
    private AmenitiesRepository amenitiesRepository;

    public List<Amenities> getAllAmenities() { return amenitiesRepository.findAll(); }

    public void saveAmenities(Amenities amenities) { amenitiesRepository.save(amenities); }

    public Amenities getAmenitiesById(Integer id) { return amenitiesRepository.findById(id).get(); }

    public void deleteAmenities(Integer id) { amenitiesRepository.deleteById(id); }
}
