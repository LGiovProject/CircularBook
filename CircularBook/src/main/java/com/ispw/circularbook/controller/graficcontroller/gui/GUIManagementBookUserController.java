package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.session.ControllerSession;
import com.ispw.circularbook.engineering.session.Session;

import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class GUIManagementBookUserController {
    GUIHomepageController guiHomepageController;
    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;




    public void searchMyBook() throws IOException {
        List<BookBean> listBookBean = new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookBean = searchBookController.searchMyBook(Session.getCurrentSession().getUserBean().getEmail());
        } catch (NoBookLendedException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (listBookBean!=null && !listBookBean.isEmpty()) {
            if(Session.getCurrentSession().getUserBean() != null) {
                Session.getCurrentSession().getUserBean().setBookOwnList(listBookBean);
            }else{
                Session.getCurrentSession().getLibraryBean().setBookOwnList(listBookBean);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewBook(listBookBean);

        } else {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non hai nessun libro registrato");
        }
    }

    public void searchBookILendBack() throws IOException {
        List<BookBean> listBookBean;
        listBookBean = Session.getCurrentSession().getUserBean().getBookBeanTaked();
        if (listBookBean!=null && !listBookBean.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewMyLendedBook(listBookBean);

        }
        else
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non hai nessun libro preso in prestito");
        }
    }

    public void searchBookIGiven() throws IOException {
        List<BookBean> listBookBean= new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookBean = searchBookController.searchMyGivenBook(Session.getCurrentSession().getUserBean().getEmail());
        }catch (NoBookLendedException e){
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (!listBookBean.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewMyGivenBook(listBookBean);

        }
    }
}
