package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookPersonalController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookSearchedController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ElementBookSearchedViewFactory implements ViewFactory {
    @Override
    public Pane createPane(ElementBookBean elementBookBean) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load();
        return pane;
    }

    @Override
    public GUIElementBookSearchedController createController() {
        return new GUIElementBookSearchedController();
    }
}
