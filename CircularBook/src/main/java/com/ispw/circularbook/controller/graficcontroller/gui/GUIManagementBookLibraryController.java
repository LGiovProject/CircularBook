package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class GUIManagementBookLibraryController {


    GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;

    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void searchMyBook() throws IOException{
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        try {
            listBookModel = searchBookController.searchMyAvailableBook(Session.getCurrentSession().getLibrary().getEmail());
            Session.getCurrentSession().getLibrary().setBookOwnList(listBookModel);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.setCurrentPane(pane);
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewBook();

        } catch (NoBookRegisteredException e) {
            MessageSupport.PopUpsExceptionMessage(e.getMessage());
        }

    }

    public void searchMySales() throws Exception {
        List<SalesModel> salesModelList;
        SearchSalesController searchSalesController = new SearchSalesController();
        salesModelList = searchSalesController.searchSales(Session.getCurrentSession().getLibrary().getEmail());

        if(!salesModelList.isEmpty())
        {
            Session.getCurrentSession().getLibrary().setSalesModelList(salesModelList);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();

            Session.getCurrentSession().getSceneFacade().loadScene(pane);


            guiWindowElementBookPersonalController = fxmlLoader.getController();

            guiWindowElementBookPersonalController.setCurrentPane(pane);
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewSales();

        } else{
            MessageSupport.PopUpsExceptionMessage("Non hai nessuna inserzione registrata");
        }
    }


    public void searchBookGiven() throws IOException {
        List<BookModel> bookModelIGivenList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookModelIGivenList = searchBookController.searchMyGivenBook(Session.getCurrentSession().getLibrary().getEmail());
            Session.getCurrentSession().getLibrary().setBookGivenList(bookModelIGivenList);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiWindowElementBookPersonalController = fxmlLoader.getController();
            guiWindowElementBookPersonalController.setPreviuosScene(previuosScene);
            guiWindowElementBookPersonalController.viewMyGivenBook();
        }catch (NoBookLendedException e){
            MessageSupport.PopUpsExceptionMessage(e.getMessage());
        }
    }


}
