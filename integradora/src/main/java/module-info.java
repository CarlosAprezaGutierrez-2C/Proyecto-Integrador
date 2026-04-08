module com.example.integradora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integradora to javafx.fxml;
    exports com.example.integradora;

    opens com.example.integradora.services to javafx.fxml;
    exports com.example.integradora.services;

    opens com.example.integradora.repositories to javafx.fxml;
    exports com.example.integradora.controllers;

    opens com.example.integradora.controllers to javafx.fxml;
    exports com.example.integradora.repositories;

    opens com.example.integradora.Models to javafx.base, javafx.fxml;
    exports com.example.integradora.Models;

}