package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageSideButtonLibraryController {





    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void goInsertSales() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertSales.fxml"));
        Pane pane= fxmlLoader.load();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);




    }

    public void goLendBook() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertLendBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertLendBookController guiInsertLendBookController = fxmlLoader.getController();
        guiInsertLendBookController.startRegisterBook();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);


    }

    public void giveBook() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertGiftBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertGiftBookController guiInsertGiftBookController = fxmlLoader.getController();
        guiInsertGiftBookController.startRegisterBook();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);

    }

    public void goManagement() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookLibrary.fxml"));
        Pane pane= fxmlLoader.load();
        GUIManagementBookLibraryController guiManagementBookLibraryController = fxmlLoader.getController();
        if(previuosScene==null)
            System.out.println("GUIHomepageSideButtonLibraryController.goManagement() E' un bel bel problema ");
        guiManagementBookLibraryController.setPreviuosScene(previuosScene);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

    }
}
