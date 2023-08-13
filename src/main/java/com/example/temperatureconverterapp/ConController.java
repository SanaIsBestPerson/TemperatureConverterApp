package com.example.temperatureconverterapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class ConController {

    //Global variables
    String ComFromValue,ComToValue,txtInputValue;
    @FXML
    private Label lblDisplay;
    @FXML
    private TextField txtInput;
    @FXML
    private ComboBox comTo;
    @FXML
    private ComboBox comFrom;

    //event handler
    @FXML
    protected void onComFromClick() {
        ComFromValue = (String) comFrom.getValue();
        calculation(txtInputValue);
    }
    @FXML
    protected void onComToClick() {
        ComToValue = (String) comTo.getValue();
        calculation(txtInputValue);
    }
    @FXML
    protected void onTextFieldClick(KeyEvent event) {
        txtInputValue = txtInput.getText();
        calculation(txtInputValue);
    }

    //startup
    ObservableList<String> list = FXCollections.observableArrayList("Celsius (°C)","Fahrenheit (°F)","Kelvin (K)");
    public void initialize() {
        comTo.setItems(list);
        comFrom.setItems(list);
        txtInput.setOnKeyReleased(this::onTextFieldClick);
    }

    //error handling
    boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }


    //calculation part
    public void calculation(String txtValue){

        if(txtValue != "" && isDouble(txtValue)){
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
