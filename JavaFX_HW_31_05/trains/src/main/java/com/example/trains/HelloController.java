package com.example.trains;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private void onHelloButtonClick() throws IOException {
        HelloApplication.setRoot("AddFlight");
    }
}