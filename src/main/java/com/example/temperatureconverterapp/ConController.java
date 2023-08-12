package com.example.temperatureconverterapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConController {
    @FXML
    private Label lblDisplay;
    @FXML
    private TextField txtInput;
    @FXML
    private ComboBox comTo;
    @FXML
    private ComboBox comFrom;
    @FXML
    protected void onButtonClick() {
        lblDisplay.setText("Ans is here");
    }

    ObservableList<String> list = FXCollections.observableArrayList("Celsius (°C)","Fahrenheit (°F)","Kelvin (K)");
    public void initialize() {
        comTo.setItems(list);
        comFrom.setItems(list);
    }


}
