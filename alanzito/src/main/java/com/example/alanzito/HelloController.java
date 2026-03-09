package com.example.alanzito;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String pass = passwordField.getText();

        // Validaciones de tu tarea
        if (email.length() < 4) {
            errorLabel.setText("Mínimo 4 caracteres en usuario");
        } else if (!email.contains("@") || !email.contains(".")) {
            errorLabel.setText("Formato de correo inválido");
        } else if (pass.length() < 6) {
            errorLabel.setText("Password mínimo 6 caracteres");
        } else {
            errorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            errorLabel.setText("¡Login exitoso!");
            // Aquí llamarías a la función para cambiar de pantalla
        }
    }
}