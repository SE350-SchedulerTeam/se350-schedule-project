module com.se350.scheduler {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.se350.scheduler to javafx.fxml;
    exports com.se350.scheduler;
}
