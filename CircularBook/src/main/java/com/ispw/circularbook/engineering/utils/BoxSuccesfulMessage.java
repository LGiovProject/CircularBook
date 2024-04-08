package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Popup;

import java.io.IOException;

public class BoxSuccesfulMessage {
    public static void SuccesfulPopUps(String message)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsSuccesfull.fxml"));
            Popup popup = new Popup();
            Label label = fxmlLoader.load();
            label.setText(message);
            popup.getContent().add(label);
            popup.setAutoHide(true);
            popup.show(Main.getStage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
