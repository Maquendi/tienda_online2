package com.tienda.online;

import com.tienda.online.app.cmd.CliApplicationStartup;
import com.tienda.online.app.jfx.JfxApplicationStartup;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaOnlineApplicationStartup extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new JfxApplicationStartup().onStart(stage);
       // new CliApplicationStartup().onStart();
    }

    public static void main(String[] args) {
        launch();
    }
}