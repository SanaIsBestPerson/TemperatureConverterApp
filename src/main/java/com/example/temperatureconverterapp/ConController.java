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

    public void calculation(String txtValue){

        if(txtValue != ""){
            if(ComFromValue == ComToValue){
                lblDisplay.setText(txtValue);
            }else if(ComFromValue=="Celsius (°C)" && ComToValue =="Fahrenheit (°F)"){

                 lblDisplay.setText(String.valueOf((double) Math.round(((Double.parseDouble(txtValue)  * 9 / 5)+ 32) * 100) / 100));

            }else if(ComFromValue=="Celsius (°C)" && ComToValue =="Kelvin (K)"){

                lblDisplay.setText(String.valueOf((double) Math.round((Double.parseDouble(txtValue) + 273.15)  * 100) / 100));

            }else if(ComFromValue=="Fahrenheit (°F)" && ComToValue =="Celsius (°C)"){

                lblDisplay.setText(String.valueOf((double) Math.round((Double.parseDouble(txtValue) - 32) * 5 / 9 * 100) / 100));

            }else if(ComFromValue=="Fahrenheit (°F)" && ComToValue =="Kelvin (K)"){

                lblDisplay.setText(String.valueOf((double) Math.round((((Double.parseDouble(txtValue) - 32) * 5 / 9 )+273.5)* 100) / 100));

            }else if(ComFromValue=="Kelvin (K)" && ComToValue =="Celsius (°C)"){

                lblDisplay.setText(String.valueOf((double) Math.round((Double.parseDouble(txtValue) - 273.15)  * 100) / 100));

            }else if(ComFromValue=="Kelvin (K)" && ComToValue =="Fahrenheit (°F)"){

                lblDisplay.setText(String.valueOf((double) Math.round((((Double.parseDouble(txtValue)-273.5)  * 9 / 5)+ 32) * 100) / 100));

            }
        }
    }
}
