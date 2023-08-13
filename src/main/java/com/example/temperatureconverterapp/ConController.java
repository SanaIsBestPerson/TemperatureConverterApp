package com.example.temperatureconverterapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class ConController {
    String ComFromValue,ComToValue;
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
        ComFromValue = (String) comFrom.getValue();
    }
    @FXML
    protected void onComToClick() {
        ComToValue = (String) comTo.getValue();
    }
    @FXML
    protected void onTextFieldClick(KeyEvent event) {
        String txtInputValue = txtInput.getText();
        calculation(txtInputValue);
    }
    ObservableList<String> list = FXCollections.observableArrayList("Celsius (°C)","Fahrenheit (°F)","Kelvin (K)");
    public void initialize() {
        comTo.setItems(list);
        comFrom.setItems(list);
        txtInput.setOnKeyReleased(this::onTextFieldClick);
    }

    public void calculation(String txtInputValue){
        if(ComFromValue == ComToValue){
            lblDisplay.setText(txtInputValue);
        }
    }


}
