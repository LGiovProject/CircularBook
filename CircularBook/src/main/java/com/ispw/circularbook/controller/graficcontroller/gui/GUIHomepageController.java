package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.NotifyController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.NotifyBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.utils.BoxSuccesfulMessage;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Popup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GUIHomepageController {

    @FXML
    private AnchorPane SideButton;
    @FXML
    private AnchorPane SideWindow;
    @FXML
    private ImageView bellNotify;

    private LoginBean loginBean;

    private List<NotifyBean> notifyBeanList = new ArrayList<>();

    private boolean notify;

    private Scene currentScene;

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    //Metodo di lancio per l'homepage sia user che library, base al tipo di utente che effettua il login
    //carica la rispettiva homepage.
    public void homePageStart(LoginBean loginBean) throws IOException {
        this.loginBean=loginBean;

        if(this.loginBean.getType()==1) {
            this.startUserHomepage();

        }
        else if(this.loginBean.getType()==2){
            this.startLibraryHomepage();

        }

    }
    //Carica l'homepage per gli utenti
    public void startUserHomepage() throws IOException {
        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonUser.fxml"));
        Pane screenA = fxmlLoaderA.load();
        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
        Pane screenB = fxmlLoaderB.load();

        setSideButton(screenA);
        setSideWindow(screenB);

        List<BookModel> listBookModel=Session.getCurrentSession().getUser().getBookTaked();
        setBellNotify(listBookModel);
    }
    //carica l'homepage per le library
    public void startLibraryHomepage() throws IOException {
        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonLibrary.fxml"));
        Pane screenA = fxmlLoaderA.load();
        GUIHomepageSideButtonLibraryController guiHomepageSideButtonLibraryController = fxmlLoaderA.getController();
        guiHomepageSideButtonLibraryController.setCurrentScene(getCurrentScene());



        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
        Pane screenB = fxmlLoaderB.load();


        setSideButton(screenA);
        setSideWindow(screenB);
    }

    public void setSideButton(Pane pane) {
        SideButton.getChildren().add(pane);
    }

    public void setSideWindow(Pane pane) {
        clearSideWindow();
        SideWindow.getChildren().add(pane);
    }

    public void clearSideWindow() {
        SideWindow.getChildren().clear();
    }

    public void logOut() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Parent root =fxmlLoader.load();
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Session.closeSession();
    }

    public void setting() throws IOException {
        if(this.loginBean.getType()==1) {
            this.settingUser();


        }
        else if(this.loginBean.getType()==2){
            this.settingLibrary();

        }
    }

    public void settingUser() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingUser.fxml"));
        GUISettingUserController guiSettingUserController;
        Parent root =fxmlLoader.load();
        guiSettingUserController = fxmlLoader.getController();
        guiSettingUserController.startSetting();
        guiSettingUserController.setPreviousScene(getCurrentScene());
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
    }

    public void settingLibrary() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingLibrary.fxml"));
        Parent root =fxmlLoader.load();
        GUISettingLibraryController guiSettingLibraryController;
        guiSettingLibraryController =fxmlLoader.getController();
        guiSettingLibraryController.startSetting();
        guiSettingLibraryController.setPreviousScene(getCurrentScene());
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
    }

    private void setBellNotify(List<BookModel> listBookModel) throws IOException {
        if(listBookModel!=null) {
            for (BookModel bookModel : listBookModel) {

                if (bookModel.getDaysRemaing() > 7) {
                    notify = true;
                    NotifyBean notifyBean = new NotifyBean(bookBean, getMessage(bookBean));
                    this.notifyBeanList.add(notifyBean);
                    Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/bellNotify.png")).openStream());
                    bellNotify.setImage(image);
                    bellNotify.setOpacity(1);
                }
            }
        }
        else
        {
            notify=false;
        }
        NotifyController notifyController= new NotifyController();
        List<NotifyBean> notifyBeanList =notifyController.readNotify(Session.getCurrentSession().getUser().getEmail());

        if(notifyBeanList!=null) {
            this.notifyBeanList.addAll(notifyController.readNotify(Session.getCurrentSession().getUser().getEmail()));
            notify=true;
        }




    }

    public void seeNotify() throws IOException {
        if(notify) {
            Popup popup = new Popup();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsNotify.fxml"));
            Label label = fxmlLoader.load();
            GUIPopUpsNotifyController popUpsNotifyController= fxmlLoader.getController();
            popUpsNotifyController.setViewNotify(this.notifyBeanList);
            popup.getContent().add(label);
            popup.setAutoHide(true);

            popup.show(Main.getStage());
            Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/bell.png")).openStream());
            bellNotify.setOpacity(0.5);
            bellNotify.setImage(image);
        }
        else
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non ci sono nuove notifiche");
        }
    }

    private String getMessage(BookBean bookBean){

        String string= "Il libro "+bookBean.getTitolo()+" che hai preso in prestito scadrà tra "+bookBean.getDaysRemaing()+" giorni";
        return string;
    }

}