module com.example.temperatureconverterapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperatureconverterapp to javafx.fxml;
    exports com.example.temperatureconverterapp;
}