package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoadPane {

    public static Pane LoadPane(String file_fxml) throws IOException {

        Pane pane;
        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource(file_fxml));
        pane = fxmlLoaderB.load();
        return pane;
    }
}
