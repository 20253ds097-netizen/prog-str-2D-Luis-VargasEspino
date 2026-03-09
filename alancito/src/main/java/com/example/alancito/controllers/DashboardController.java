package com.example.alancito.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label welcomeLabel;

    public void setWelcome(String user) {
        welcomeLabel.setText("Bienvenido, " + user);
    }
}