package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookGivenController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ElementBookGivenViewFactory implements ViewFactory {
    @Override
    public Pane createPane(ElementBean elementBean) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
        GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
        guiElementBookGivenController.startSetElementGivenBook(elementBean);
        Pane pane = fxmlLoader.load();
        return pane;
    }

    @Override
    public GUIElementBookGivenController createController() {
        return new GUIElementBookGivenController();
    }
}
