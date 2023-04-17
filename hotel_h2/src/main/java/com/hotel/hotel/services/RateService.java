package com.hotel.hotel.services;

import com.hotel.hotel.models.Rate;
import com.hotel.hotel.repositories.RateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RateService {
    @Autowired
    private RateRepository rateRepository;

    public List<Rate> getAllRates() { return rateRepository.findAll(); }

    public void saveRate(Rate rate) { rateRepository.save(rate); }

    public Rate getRateById(Integer id) { return rateRepository.findById(id).get(); }

    public void deleteRate(Integer id) { rateRepository.deleteById(id); }
}

