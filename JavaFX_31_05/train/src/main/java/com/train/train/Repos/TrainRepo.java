package com.train.train.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.train.Models.Train;

/**
 * The TrainRepo interface extends JpaRepository and provides additional methods to interact with Train entities stored in the database.
 */
public interface TrainRepo extends JpaRepository<Train, Long>{
    
}