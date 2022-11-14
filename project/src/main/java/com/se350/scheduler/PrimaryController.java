package com.se350.scheduler;

import java.io.IOException;
import javafx.fxml.FXML;
import com.se350.scheduler.logic.*;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
