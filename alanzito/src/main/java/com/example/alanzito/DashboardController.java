package com.example.alanzito;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label welcomeLabel;

    public void setUserName(String name) {
        welcomeLabel.setText("Bienvenido, " + name);
    }

    @FXML
    private void handleLogout() {
        System.exit(0);
    }
}