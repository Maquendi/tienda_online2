package com.tienda.online.app.jfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TiendaOnlineApplicationMainController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}