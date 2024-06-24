module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.demo.tableview to javafx.base;
    opens org.example.demo to javafx.fxml, javafx.graphics;
    opens org.example.demo.entity to javafx.fxml, javafx.graphics;
    opens org.example.demo.controller to javafx.fxml, javafx.graphics;
    exports org.example.demo;
    exports org.example.demo.tableview to javafx.graphics;
    exports org.example.demo.entity;
}