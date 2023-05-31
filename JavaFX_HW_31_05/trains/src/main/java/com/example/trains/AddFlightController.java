package com.example.trains;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.json.JSONArray;
import org.json.JSONObject;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddFlightController {

    private static final String FILE_PATH = "resources/com/example/trains/trains.json";
    // C:\Users\Admin\Desktop\JavaHW\TrainsFX\trains\src\main\resources\com\example\trains\trains.json
    @FXML
    private Label trainInfoLabel;

    @FXML
    private TextField fromCityField;

    @FXML
    private TextField toCityField;

    @FXML
    private DatePicker departureDateField;

    @FXML
    private TextField departureTimeField;

    @FXML
    private DatePicker arrivalDateField;

    @FXML
    private TextField arrivalTimeField;

    @FXML
    private TextField basePriceField;

    // @FXML
    // private ComboBox<String> trainComboBox;

    @FXML
    protected void returnToMain() throws IOException {
        HelloApplication.setRoot("hello-view");
    }

    @FXML
    public void showTrainInfo() {
        try {
            // Read the contents of the trains.json file
            String content = Files.readString(Paths.get(FILE_PATH), StandardCharsets.UTF_8);

            // Parse the JSON data
            JSONArray jsonArray = new JSONArray(content);

            // Create an empty string to hold the train information
            StringBuilder trainInfoBuilder = new StringBuilder();

            // Loop through the array and append the train information to the string
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String type = jsonObject.getString("type");
                int num_wagons = jsonObject.getInt("num_wagons");
                int seats_per_wagon = jsonObject.getInt("seats_per_wagon");
                trainInfoBuilder.append(name).append(": ").append(type).append(", ").append(num_wagons)
                        .append(" wagons, ").append(seats_per_wagon).append(" seats per wagon\n");
            }

            // Set the label text to the train information
            trainInfoLabel.setText(trainInfoBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method that will be called when the "Save" button is clicked
    // @FXML
    // void saveFlightDetails() {
    //     String fromCity = fromCityField.getText();
    //     String toCity = toCityField.getText();
    //     LocalDate departureDate = departureDateField.getValue();
    //     LocalTime departureTime = LocalTime.parse(departureTimeField.getText());
    //     LocalDateTime departureDateTime = LocalDateTime.of(departureDate, departureTime);
    //     LocalDate arrivalDate = arrivalDateField.getValue();
    //     LocalTime arrivalTime = LocalTime.parse(arrivalTimeField.getText());
    //     LocalDateTime arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
    //     double basePrice = Double.parseDouble(basePriceField.getText());
    //     String selectedTrain = trainComboBox.getValue();

    // You can then pass these flight details to your backend code or database for further processing
    // }
}
