package com.example.temperatureconverterapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

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
    protected void onComFromClick() {
        lblDisplay.setText("onComFromClick");
    }
    @FXML
    protected void onComToClick() {
        lblDisplay.setText("onComToClick");
    }
    @FXML
    protected void onTextFieldClick(KeyEvent event) {
        String txtInputValue = txtInput.getText();
        lblDisplay.setText(txtInputValue);
    }
    ObservableList<String> list = FXCollections.observableArrayList("Celsius (°C)","Fahrenheit (°F)","Kelvin (K)");
    public void initialize() {
        comTo.setItems(list);
        comFrom.setItems(list);
        txtInput.setOnKeyReleased(this::onTextFieldClick);
    }


}
