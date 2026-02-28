package com.example.logindashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String pass = passwordField.getText();

        if (email.length() < 4) {
            errorLabel.setText("Error: El usuario debe tener mín. 4 caracteres.");
        }
        else if (!email.contains("@") || !email.contains(".")) {
            errorLabel.setText("Error: Formato de correo inválido (falta @ o .).");
        }
        else if (pass.length() < 6) {
            errorLabel.setText("Error: La contraseña debe tener mín. 6 caracteres.");
        }
        else {
            errorLabel.setText("");
            mostrarDashboard(email);
        }
    }

    private void mostrarDashboard(String usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Parent root = loader.load();

            DashboardController dashCtrl = loader.getController();
            dashCtrl.setMensaje(usuario);
            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}