module com.example.integrador {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.example.integrador to javafx.fxml;
    opens com.example.integrador.controllers to javafx.fxml;
    opens com.example.integrador.Models to javafx.base;

    exports com.example.integrador;
}