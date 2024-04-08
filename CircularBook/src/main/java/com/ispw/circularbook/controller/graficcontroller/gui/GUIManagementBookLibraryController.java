package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.Bean.BookBean;
import com.ispw.circularbook.engineering.Bean.SalesBean;
import com.ispw.circularbook.engineering.Session.ControllerSession;
import com.ispw.circularbook.engineering.Session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIManagementBookLibraryController {

    GUIHomepageController guiHomepageController;
    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;

    public void searchMyBook() throws IOException {
        List<BookBean> listBookBean= new ArrayList<>();
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookBean = searchBookController.searchMyBook(Session.getCurrentSession().getLibraryBean().getEmail());
        } catch (NoBookLendedException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        if (listBookBean.size() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = ControllerSession.getGuiHomepageController();
            guiHomepageController.setSideWindow(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.viewBook(listBookBean);
        } else {

        }
    }

    public void searchMySales() throws Exception {
        List<SalesBean> salesBeanList;
        SearchSalesController searchSalesController = new SearchSalesController();
        salesBeanList = searchSalesController.searchSales(Session.getCurrentSession().getLibraryBean().getEmail());
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
