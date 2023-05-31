package com.train.train.Controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.train.train.TrainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * The AddFlightController class controls the behavior of the "addFlight" view.
 */
@Component
public class AddFlightController {

    @FXML
    private TextField nameField;

    /**
     * Navigates back to the main view.
     * 
     * @throws IOException if an I/O error occurs.
     */
    public void returnToMain() throws IOException{
        TrainApplication.setRoot("main");
    }
}