package org.se350.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.se350.logic.Event;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Table
    @FXML
    private TableView<Event> tableView;

    // Columns
    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private TableColumn< Event, String> dateColumn;

    @FXML
    private TableColumn<Event, String> timeColumn;

    // Text input
    @FXML
    private TextField nameInput;

    @FXML
    private TextArea descriptionInput;

    @FXML
    private DatePicker startDateInput;

    @FXML
    private DatePicker endDateInput;

    @FXML
    private TextField startTimeHourInput;

    @FXML
    private TextField startTimeMinuteInput;

    @FXML
    private TextField endTimeHourInput;

    @FXML
    private TextField endTimeMinuteInput;

    //Button
    @FXML
    private Button primaryButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("date1"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("startHour"));
    }

    // Create button
    @FXML
    void createEvent(ActionEvent event) {
        Event newEvent = new Event(nameInput.getText(),
                descriptionInput.getText(),
                startDateInput.getValue(),
                endDateInput.getValue(),
                Integer.parseInt(startTimeHourInput.getText()),
                Integer.parseInt(startTimeMinuteInput.getText()),
                Integer.parseInt(endTimeHourInput.getText()),
                Integer.parseInt(endTimeMinuteInput.getText()));
        ObservableList<Event> newEvents = tableView.getItems();
        newEvents.add(newEvent);
        tableView.setItems(newEvents);
    }

    // Remove button
    @FXML
    void removeEvent(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    // Switch to calendar view
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org.se350.gui/secondary.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
