package com.se350.scheduler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.se350.scheduler.logic.*;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<Event> tableView;

    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private TableColumn< Event, String> dateColumn;

    @FXML
    private TableColumn<Event, String> timeColumn;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField descriptionInput;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("date1"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("parseInt" + ":" + "parseInt2"));
    }
    
    @FXML
    void createEvent(ActionEvent event) {
        Event newEvent = new Event(nameInput.getText(),
            descriptionInput.getText(),
            startDateInput.getPromptText(),
            endDateInput.getPromptText(),
            Integer.parseInt(startTimeHourInput.getText()),
            Integer.parseInt(startTimeMinuteInput.getText()),
            Integer.parseInt(endTimeHourInput.getText()),
            Integer.parseInt(endTimeMinuteInput.getText()));
        ObservableList<Event> newEvents = tableView.getItems();
        newEvents.add(newEvent);
        tableView.setItems(newEvents);
    }

    @FXML
    void removeEvent(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

}
