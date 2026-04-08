  module com.example.integradora {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;
    requires javafx.graphics;



    opens com.example.integradora to javafx.fxml;
    opens com.example.integradora.controllers to javafx.fxml;
    opens com.example.integradora.Models to javafx.base;

    exports com.example.integradora;
}