package com.train.train.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.train.Models.Train;
import com.train.train.Repos.TrainRepo;

import jakarta.transaction.Transactional;

/**
 * The TrainService class provides methods to interact with Train entities stored in the database.
 */
@Service
@Transactional
public class TrainService {

    @Autowired
    private TrainRepo trainRepo;

    /**
     * Saves a Train entity to the database.
     * 
     * @param train - the Train entity to save.
     */
    public void saveTrain(Train train) {
        trainRepo.save(train);
    }
    
    /**
     * Retrieves all Train entities from the database.
     * 
     * @return a List of all Train entities.
     */
    public List<Train> getAllTrains() {
        return trainRepo.findAll();
    }
}
