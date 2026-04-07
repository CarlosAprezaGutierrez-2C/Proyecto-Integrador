  module com.example.integradora {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.integradora to javafx.fxml;
    opens com.example.integradora.controllers to javafx.fxml;
    opens com.example.integradora.Models to javafx.base;

    exports com.example.integradora;
}