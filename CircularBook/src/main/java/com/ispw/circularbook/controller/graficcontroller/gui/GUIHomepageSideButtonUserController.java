package com.ispw.circularbook.controller.graficcontroller.gui;


import com.ispw.circularbook.engineering.exception.AccountRequiredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class GUIHomepageSideButtonUserController {


    private Scene previuosScene;

    public Scene getPreviuosScene() {
        return previuosScene;
    }

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void openLendBook() throws IOException {
        try {
        if(Session.getCurrentSession().getUser().isGuest())
            throw new AccountRequiredException();


            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertLendBook.fxml"));
            Pane pane = fxmlLoader.load();
            GUIInsertLendBookController guiInsertLendBookController = fxmlLoader.getController();
            guiInsertLendBookController.startRegisterBook();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);


//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
        } catch (AccountRequiredException e) {
            BoxExcpetionMessage.PopUpsGuestDeniedMessage();
        }

    }

    public void giveBook() throws IOException {
        try {
            if (Session.getCurrentSession().getUser().isGuest())
                throw new AccountRequiredException();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertGiftBook.fxml"));
            Pane pane = fxmlLoader.load();
            GUIInsertGiftBookController guiInsertGiftBookController = fxmlLoader.getController();
            guiInsertGiftBookController.startRegisterBook();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
        }catch (AccountRequiredException e)
        {
            BoxExcpetionMessage.PopUpsGuestDeniedMessage();
        }

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void searchSales() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchSales.fxml"));
        Pane pane= fxmlLoader.load();
        GUISearchSalesController guiSearchSalesController = fxmlLoader.getController();
        guiSearchSalesController.startSetSales();
        guiSearchSalesController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void searchBook() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUISearchBookController guiSearchBookController= fxmlLoader.getController();
        guiSearchBookController.setSearch();
        guiSearchBookController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);


//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);
    }

    public void showLibrary() throws IOException{
       try {
           if (Session.getCurrentSession().getUser().isGuest())
               throw new AccountRequiredException();
           FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
           Pane pane = fxmlLoader.load();
           GUIManagementBookUserController guiManagementBookUserController = fxmlLoader.getController();
           guiManagementBookUserController.setPreviuosScene(previuosScene);
           Session.getCurrentSession().getSceneFacade().loadScene(pane);
       }catch (AccountRequiredException e)
       {
           BoxExcpetionMessage.PopUpsGuestDeniedMessage();
       }
//        guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);




    }




}
