package com.hotel.hotel.services;

import com.hotel.hotel.models.Level;
import com.hotel.hotel.repositories.LevelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;

    public List<Level> getAllLevels() { return levelRepository.findAll(); }

    public void saveLevel(Level level) { levelRepository.save(level); }

    public Level getLevelById(Integer id) { return levelRepository.findById(id).get(); }

    public void deleteLevel(Integer id) { levelRepository.deleteById(id); }
}

