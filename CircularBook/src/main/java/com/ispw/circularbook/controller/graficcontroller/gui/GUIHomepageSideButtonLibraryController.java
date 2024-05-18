package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageSideButtonLibraryController {


    private GUIHomepageController guiHomepageController;


    public void goInsertSales() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertSales.fxml"));
        Pane pane= fxmlLoader.load();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);


    }

    public void goLendBook() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertLendBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertLendBookController guiInsertLendBookController = fxmlLoader.getController();
        guiInsertLendBookController.startRegisterBook();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);

    }

    public void giveBook() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertGiftBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertGiftBookController guiInsertGiftBookController = fxmlLoader.getController();
        guiInsertGiftBookController.startRegisterBook();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void goManagement() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookLibrary.fxml"));
        Pane pane= fxmlLoader.load();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }
}
