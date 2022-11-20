package org.se350.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.se350.logic.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    @FXML
    private ChoiceBox<String> remindChoice;
    @FXML
    private TextField remindInt;

    @FXML
    private TextField remindMsg;

    private DailyPlanner dp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("startDate"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("startTime"));

        // populate choice box
        ObservableList<String> choices = FXCollections.observableArrayList();
        choices.addAll("Minutes", "Hours", "Days");
        remindChoice.setItems(choices);

        // logic
        dp = new DailyPlanner();
    }

    // Create button
    @FXML
    void createEvent(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        String start_time_string = startTimeHourInput.getText() + ":" + startTimeMinuteInput.getText();
        String end_time_string = endTimeHourInput.getText() + ":" + endTimeMinuteInput.getText();

        TimeSlot slot = new TimeSlot(startDateInput.getValue(), LocalTime.parse(start_time_string, formatter), endDateInput.getValue(), LocalTime.parse(end_time_string, formatter));
        Event newEvent = new Event(
                nameInput.getText(),
                descriptionInput.getText(),
                EventType.WORK,
                slot
        );

        TimeMeasurement reminder_measurement = null;
        switch(remindChoice.getValue()) {
            case "Minutes":
                reminder_measurement = TimeMeasurement.MINUTE;
                break;
            case "Hours":
                reminder_measurement = TimeMeasurement.HOUR;
                break;
            case "Days":
                reminder_measurement = TimeMeasurement.DAY;
                break;
        }

        newEvent.createReminder(Integer.parseInt(remindInt.getText()), reminder_measurement, remindMsg.getText());

        dp.addEvent(newEvent);
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
