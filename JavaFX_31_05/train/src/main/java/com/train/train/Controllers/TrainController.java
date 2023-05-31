package com.train.train.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.train.Models.Train;
import com.train.train.Services.TrainService;

/**
 * The TrainController class provides RESTful endpoints to interact with Train entities.
 */
@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    /**
     * Retrieves all Train entities from the database.
     * 
     * @return a List of all Train entities.
     */
    @GetMapping("/get")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    /**
     * Saves a new Train entity to the database.
     * 
     * @param train - the Train entity to save.
     */
    @PostMapping("/post")
    public void addTrain(@RequestBody Train train) {
        trainService.saveTrain(train);
    }
}
