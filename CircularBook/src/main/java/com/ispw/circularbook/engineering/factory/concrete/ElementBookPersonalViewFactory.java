package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookGivenController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookPersonalController;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;

public class ElementBookPersonalViewFactory implements ViewFactory {
    @Override
    public FXMLLoader createFxmlLoader() {
        return new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
    }

    @Override
    public GUIElementBookPersonalController createController() {
        return new GUIElementBookPersonalController();
    }
}
