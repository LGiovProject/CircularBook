package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookSearchedController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookTakedController;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;

public class ElementBookTakedViewFactory implements ViewFactory {
    @Override
    public FXMLLoader createFxmlLoader() {
        return new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));

    }

    @Override
    public GUIElementBookTakedController createController() {
        return new GUIElementBookTakedController();
    }
}
