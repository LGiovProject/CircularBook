package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookPersonalController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookSearchedController;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;

public class ElementBookSearchedViewFactory implements ViewFactory {
    @Override
    public FXMLLoader createFxmlLoader() {
        return new FXMLLoader();
    }

    @Override
    public GUIElementBookSearchedController createController() {
        return new GUIElementBookSearchedController();
    }
}
