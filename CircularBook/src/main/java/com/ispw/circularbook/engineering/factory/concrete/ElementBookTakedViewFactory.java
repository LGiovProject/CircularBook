package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookTakedController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ElementBookTakedViewFactory implements ViewFactory {
    @Override
    public Pane createPane(ElementBean elementBean) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));
        GUIElementBookTakedController guiElementBookTakedController = fxmlLoader.getController();
        guiElementBookTakedController.startSetElementTakedBook(elementBean);
        Pane pane = fxmlLoader.load();
        return pane;
    }

    @Override
    public GUIElementBookTakedController createController() {
        return new GUIElementBookTakedController();
    }
}
