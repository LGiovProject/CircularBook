package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIManagementBookLibraryController {

    GUIHomepageController guiHomepageController;
    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;

    public void searchMyBook() throws IOException, NoBookLendedException {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();

        listBookModel = searchBookController.searchMyBook(Session.getCurrentSession().getLibrary().getEmail());

        if (!listBookModel.isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewBook();
        } else {

        }
    }

    public void searchMySales() throws Exception {
        List<SalesModel> salesModelList;
        SearchSalesController searchSalesController = new SearchSalesController();
        salesModelList = searchSalesController.searchSales(Session.getCurrentSession().getLibrary().getEmail());
        if(salesModelList.size()!=0)
        {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewSales(salesModelList);
        } else{

        }
    }


}
