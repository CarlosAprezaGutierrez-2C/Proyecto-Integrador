module com.example.integradora {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.example.integradora;
    requires javafx.base;
    requires javafx.graphics;

    opens com.example.integradora to javafx.fxml;
    exports com.example.integradora;
}