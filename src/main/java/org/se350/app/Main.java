package org.se350.app;

//import com.se350.logic.Event;
//import com.se350.logic.Notification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// JavaFX App
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 806, 634);
        // ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("project/src/main/resources/com/se350/scheduler/primary.fxml"), bundle);
        // Parent root = loader.load();
        stage.setTitle("Schedule Tracker");
        stage.setScene(scene);
        stage.show();
        // new PrimaryController(c);
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}