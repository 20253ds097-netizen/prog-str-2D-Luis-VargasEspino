package com.example.logindashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label welcomeLabel;

    public void setMensaje(String usuario) {
        welcomeLabel.setText("Bienvenido, " + usuario);
    }
}