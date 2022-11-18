package org.se350.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< Updated upstream
=======
import javafx.stage.StageStyle;
import org.se350.gui.PrimaryController;
>>>>>>> Stashed changes

// JavaFX App
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
<<<<<<< Updated upstream
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
=======
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org.se350.gui/primary.fxml"));
>>>>>>> Stashed changes
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Schedule Tracker");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}