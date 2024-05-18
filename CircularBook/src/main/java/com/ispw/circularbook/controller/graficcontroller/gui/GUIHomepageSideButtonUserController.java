package com.ispw.circularbook.controller.graficcontroller.gui;


import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class GUIHomepageSideButtonUserController {




    private GUIHomepageController guiHomepageController;




    public void openLendBook() throws IOException {


        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertLendBook.fxml"));
        Pane pane = fxmlLoader.load();
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

    public void searchSales() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchSales.fxml"));
        Pane pane= fxmlLoader.load();
        GUISearchSalesController guiSearchSalesController = fxmlLoader.getController();
        guiSearchSalesController.startSetSales();
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void searchBook() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUISearchBookController searchBookController= fxmlLoader.getController();
        searchBookController.setSearch();
        searchBookController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);


//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void showLibrary() throws IOException{
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
        Pane pane= fxmlLoader.load();
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);




    }




}
