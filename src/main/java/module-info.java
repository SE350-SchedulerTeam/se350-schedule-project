module org.se350 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.se350.gui to javafx.fxml;

    exports org.se350.gui;
    exports org.se350.app;

    opens org.se350.app to javafx.fxml;
}
