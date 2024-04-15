package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.session.ControllerSession;
import com.ispw.circularbook.engineering.session.Session;

import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class GUIManagementBookUserController {
    GUIHomepageController guiHomepageController;
    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;




    public void searchMyBook() throws IOException {
        List<BookModel> listBookModel = new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookModel = searchBookController.searchMyBook(Session.getCurrentSession().getUser().getEmail());
        } catch (NoBookLendedException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (listBookModel!=null && !listBookModel.isEmpty()) {
            if(Session.getCurrentSession().getUser() != null) {
                Session.getCurrentSession().getUser().setBookOwnList(listBookModel);
            }else{
                Session.getCurrentSession().getLibrary().setBookOwnList(listBookModel);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewBook(listBookModel);

        } else {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non hai nessun libro registrato");
        }
    }

    public void searchBookILendBack() throws IOException {
        List<BookModel> listBookModel;
        listBookModel = Session.getCurrentSession().getUser().getListBookTaked();
        if (listBookModel!=null && !listBookModel.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewMyLendedBook(listBookModel);

        }
        else
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non hai nessun libro preso in prestito");
        }
    }

    public void searchBookIGiven() throws IOException {
        List<BookModel> listBookModel= new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(Session.getCurrentSession().getUser().getEmail());
        }catch (NoBookLendedException e){
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (!listBookModel.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewMyGivenBook(listBookModel);

        }
    }
}
