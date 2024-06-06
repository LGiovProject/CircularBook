package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.session.Session;

import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.BoxMessageSupport;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class GUIManagementBookUserController {


    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;

    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }


    public void searchMyBook() throws IOException {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        listBookModel = searchBookController.searchMyAvailableBook(Session.getCurrentSession().getUser().getEmail());

        if (listBookModel!=null && !listBookModel.isEmpty()) {
            Session.getCurrentSession().getUser().setBookOwnList(listBookModel);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();

            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.setCurrentPane(pane);
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewBook();

        } else {

        }

    }

    public void searchBookILendBack() throws IOException {
        List<BookModel> listBookModel;
        listBookModel = Session.getCurrentSession().getUser().getListBookTaked();
        if (listBookModel!=null && !listBookModel.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();

            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewMyLendedBook();


        }
        else
        {
            BoxMessageSupport.PopUpsExcpetionMessage("Non hai nessun libro preso in prestito");
        }
    }

    public void searchBookIGiven() throws IOException {
        List<BookModel> listBookModel= new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(Session.getCurrentSession().getUser().getEmail());
        }catch (NoBookLendedException e){
            BoxMessageSupport.PopUpsExcpetionMessage(e.getMessage());
        }
        if (!listBookModel.isEmpty()) {
            Session.getCurrentSession().getUser().setListBookGiven(listBookModel);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();

            Session.getCurrentSession().getSceneFacade().loadScene(pane);


            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewMyGivenBook();


        }
        else
        {
            BoxMessageSupport.PopUpsExcpetionMessage("Nessuno dei tuoi libri è stato preso in prestito");
        }
    }
}
