package com.example.temperatureconverterapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConApplication.class.getResource("con-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 580);
        stage.setTitle("Temperature Converter App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}