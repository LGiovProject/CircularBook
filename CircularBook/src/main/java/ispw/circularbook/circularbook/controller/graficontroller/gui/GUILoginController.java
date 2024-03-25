package ispw.circularbook.circularbook.controller.graficontroller.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GUILoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //commentino
}