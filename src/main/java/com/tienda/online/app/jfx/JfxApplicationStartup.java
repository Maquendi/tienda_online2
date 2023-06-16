package com.tienda.online.app.jfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JfxApplicationStartup {

    public void onStart(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/tienda-online-main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Tu Tienda En Linea");
        stage.setScene(scene);
        stage.show();
    }
}
