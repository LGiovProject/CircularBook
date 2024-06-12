package com.ispw.circularbook.controller.graficcontroller.gui;


import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.NotifyBean;
import com.ispw.circularbook.engineering.facade.SceneFacade;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageState;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageLibraryState;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageUserState;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class GUIHomepageController {

    @FXML
    private AnchorPane SideButton;
    @FXML
    private AnchorPane SideWindow;
    @FXML
    private ImageView bellNotify;

    private List<NotifyBean> notifyBeanList = new ArrayList<>();

    private GUIHomepageState currentState;

    private Scene currentScene;

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    //Metodo di lancio per l'homepage sia user che library, base al tipo di utente che effettua il login
    //carica la rispettiva homepage.

    public void setState(GUIHomepageState state)
    {
        this.currentState=state;
    }

    public void homePageStart(LoginBean loginBean) throws IOException {

        SceneFacade sceneFacade = new SceneFacade(SideWindow);
        Session.getCurrentSession().setSceneFacade(sceneFacade);


        if(loginBean.getType()==1)
            this.setState(new GUIHomepageUserState());
        else if (loginBean.getType()==2)
            this.setState(new GUIHomepageLibraryState());

        currentState.startHomepage(this);
    }
    //Carica l'homepage per gli utenti
//    public void startUserHomepage() throws IOException {
//        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonUser.fxml"));
//        Pane screenA = fxmlLoaderA.load();
//        GUIHomepageSideButtonUserController guiHomepageSideButtonUserController = fxmlLoaderA.getController();
//        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
//        Pane screenB = fxmlLoaderB.load();
//
//        setSideButton(screenA);
//        setSideWindow(screenB);
//        guiHomepageSideButtonUserController.setPreviuosScene(this.currentScene);
//
//    }
    //carica l'homepage per le library
//    public void startLibraryHomepage() throws IOException {
//        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonLibrary.fxml"));
//        Pane screenA = fxmlLoaderA.load();
//        GUIHomepageSideButtonLibraryController guiHomepageSideButtonLibraryController = fxmlLoaderA.getController();
//        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
//        Pane screenB = fxmlLoaderB.load();
//
//        setSideButton(screenA);
//        setSideWindow(screenB);
//
//        guiHomepageSideButtonLibraryController.setPreviuosScene(this.currentScene);
//    }

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
        GUILoginController guiLoginController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiLoginController.setCurrentScene(scene);
        Main.getStage().setScene(scene);

        Session.closeSession();
    }

    public void setting() throws IOException {
        currentState.setting(this);
    }

//    public void settingUser() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingUser.fxml"));
//        GUISettingUserController guiSettingUserController;
//        Parent root =fxmlLoader.load();
//        guiSettingUserController = fxmlLoader.getController();
//        guiSettingUserController.startSetting();
//        guiSettingUserController.setPreviousScene(getCurrentScene());
//        Scene scene = new Scene(root);
//        Main.getStage().setScene(scene);
//    }
//
//    public void settingLibrary() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingLibrary.fxml"));
//        Parent root =fxmlLoader.load();
//        GUISettingLibraryController guiSettingLibraryController;
//        guiSettingLibraryController =fxmlLoader.getController();
//        guiSettingLibraryController.startSetting();
//        guiSettingLibraryController.setPreviousScene(getCurrentScene());
//        Scene scene = new Scene(root);
//        Main.getStage().setScene(scene);
//    }

//    private void setBellNotify(List<BookModel> listBookModel) throws IOException {
//        if(listBookModel!=null) {
//            for (BookModel bookModel : listBookModel) {
//
//                if (bookModel.getDaysRemaing() > 7) {
//                    notify = true;
//                    // Change to notifybean in NotifyModel!
//                    //NotifyBean notifyBean = new NotifyBean(bookBean, getMessage(bookBean));
//                    //this.notifyBeanList.add(notifyBean);
//                    Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/bellNotify.png")).openStream());
//                    bellNotify.setImage(image);
//                    bellNotify.setOpacity(1);
//                }
//            }
//        }
//        else
//        {
//            notify=false;
//        }
//        NotifyController notifyController= new NotifyController();
//        List<NotifyBean> notifyBeanList =notifyController.readNotify(Session.getCurrentSession().getUser().getEmail());
//
//        if(notifyBeanList!=null) {
//            this.notifyBeanList.addAll(notifyController.readNotify(Session.getCurrentSession().getUser().getEmail()));
//            notify=true;
//        }
//
//
//
//
//    }

    public void seeNotify() throws IOException {

        MessageSupport.PopUpsExcpetionMessage("Servizio non ancora implementato");

//        if(notify) {
//            Popup popup = new Popup();
//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource());
//            Label label = fxmlLoader.load();
//            GUIPopUpsNotifyController popUpsNotifyController= fxmlLoader.getController();
//            popUpsNotifyController.setViewNotify(this.notifyBeanList);
//            popup.getContent().add(label);
//            popup.setAutoHide(true);
//
//            popup.show(Main.getStage());
//            Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/bell.png")).openStream());
//            bellNotify.setOpacity(0.5);
//            bellNotify.setImage(image);
//        }
//        else
//        {
//            MessageSupport.PopUpsExcpetionMessage("Non ci sono nuove notifiche");
//        }
    }

//    private String getMessage(BookBean bookBean){
//
//        String string= "Il libro "+bookBean.getTitolo()+" che hai preso in prestito scadrà tra "+bookBean.getDaysRemaing()+" giorni";
//        return string;
//    }

}