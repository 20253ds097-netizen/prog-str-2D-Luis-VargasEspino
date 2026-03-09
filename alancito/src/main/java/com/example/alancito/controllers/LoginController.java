package com.example.alancito.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String pass = passwordField.getText();

        if (email.length() < 4) {
            errorLabel.setText("Mínimo 4 caracteres.");
        } else if (!email.contains("@") || !email.contains(".")) {
            errorLabel.setText("Correo inválido (falta @ o .)");
        } else if (pass.length() < 6) {
            errorLabel.setText("Contraseña mínimo 6 caracteres.");
        } else {
            try {
                // RUTA CRÍTICA: Aquí es donde fallaba tu código
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/alancito/views/dashboard-view.fxml"));
                Stage stage = (Stage) emailField.getScene().getWindow();
                stage.setScene(new Scene(loader.load()));

                DashboardController dash = loader.getController();
                dash.setWelcome(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}