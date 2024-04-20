package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookGivenController;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;

public class ElementBookGivenViewFactory implements ViewFactory {
    @Override
    public FXMLLoader createFxmlLoader() {
        return new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
    }

    @Override
    public GUIElementBookGivenController createController() {
        return new GUIElementBookGivenController();
    }
}
