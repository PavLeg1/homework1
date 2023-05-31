package com.train.train.Controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.train.train.TrainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * The MainController class controls the behavior of the main view.
 */
@Component
public class MainController {

    @FXML
    private TextField nameField;

    /**
     * Switches to the "addFlight" view.
     * 
     * @throws IOException if an I/O error occurs.
     */
    public void switchToAddFlight() throws IOException{
        TrainApplication.setRoot("addFlight");
    }

    /**
     * Switches to the "addTrain" view.
     * 
     * @throws IOException if an I/O error occurs.
     */
    public void switchToAddTrain() throws IOException{
        TrainApplication.setRoot("addTrain");
    }
}