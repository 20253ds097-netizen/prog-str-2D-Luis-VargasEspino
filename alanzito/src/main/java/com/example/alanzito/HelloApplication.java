package com.example.alanzito;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Aquí declaramos la variable fxmlLoader
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Usamos la misma variable fxmlLoader para cargar la escena
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hola Alanzito");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}