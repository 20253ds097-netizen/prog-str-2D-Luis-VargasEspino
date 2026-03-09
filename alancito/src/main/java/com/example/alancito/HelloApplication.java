package com.example.alancito;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Cambia tu FXMLLoader por este exactamente:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/alancito/views/login-view.fxml"));

        if (loader.getLocation() == null) {
            // Si entra aquí, imprimiremos en consola qué es lo que Java está viendo realmente
            System.out.println("DEBUG: Buscando en -> /com/example/alancito/views/login-view.fxml");
            throw new RuntimeException("¡ERROR! El archivo FXML no está en la carpeta views.");
        }
        Scene scene = new Scene(loader.load());
        stage.setTitle("Login Sistema - Luis Vargas");
        stage.setScene(scene);
        stage.show();
    }
}