package org.se350.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import org.se350.app.Main;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        Main.setRoot("primary");
    }
}
