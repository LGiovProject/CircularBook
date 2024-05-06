package com.ispw.circularbook.engineering.factory.concrete;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIElementBookGivenController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.factory.ViewFactory;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class ElementBookGivenViewFactory implements ViewFactory {
    @Override
    public Pane createFxmlLoader(BookBean bookBean) {
        FXMLLoader fxmlLoader =new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
        GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
        guiElementBookGivenController.startSetElementGivenBook(bookBean);
        Pane pane = fxmlLoader.load();
        return pane;
    }

    @Override
    public GUIElementBookGivenController createController() {
        return new GUIElementBookGivenController();
    }
}
