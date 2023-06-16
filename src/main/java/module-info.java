module tienda.online {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tienda.online.app.jfx to javafx.fxml;
    exports com.tienda.online.app.jfx;
    exports com.tienda.online;
    opens com.tienda.online to javafx.fxml;
    exports com.tienda.online.app.jfx.controllers;
    opens com.tienda.online.app.jfx.controllers to javafx.fxml;
}