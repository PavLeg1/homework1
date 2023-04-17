package com.hotel.hotel.services;

import com.hotel.hotel.models.Facilities;
import com.hotel.hotel.repositories.FacilitiesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FacilitiesService {
    @Autowired
    private FacilitiesRepository facilitiesRepository;

    public List<Facilities> getAllFacilities() { return facilitiesRepository.findAll(); }

    public void saveFacilities(Facilities facilities) { facilitiesRepository.save(facilities); }

    public Facilities getFacilitiesById(Integer id) { return facilitiesRepository.findById(id).get(); }

    public void deleteFacilities(Integer id) { facilitiesRepository.deleteById(id); }
}

