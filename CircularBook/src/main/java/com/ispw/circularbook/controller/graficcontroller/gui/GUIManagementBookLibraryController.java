package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
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

public class GUIManagementBookLibraryController {

    GUIHomepageController guiHomepageController;
    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;

    public void searchMyBook() throws IOException {
        List<BookModel> listBookModel= new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookModel = searchBookController.searchMyBook(Session.getCurrentSession().getLibrary().getEmail());
        } catch (NoBookLendedException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (listBookModel.size() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewBook(listBookModel);
        } else {

        }
    }

    public void searchMySales() throws Exception {
        List<SalesBean> salesBeanList;
        SearchSalesController searchSalesController = new SearchSalesController();
        salesBeanList = searchSalesController.searchSales(Session.getCurrentSession().getLibrary().getEmail());
        if(salesBeanList.size()!=0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewSales(salesBeanList);
        } else{

        }
    }
}
