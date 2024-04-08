package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;


import java.io.IOException;

public class GUIPopUpsLoginController {

    private Popup popup;

    public void setPopup(Popup popup){
        this.popup=popup;
    }


    public void goSignInUser(ActionEvent event) throws IOException {

        this.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInUser.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInUserController guiSignInUserController= fxmlLoader.getController();
        guiSignInUserController.startSignIn();

        Scene scene = new Scene(root);

        Main.getStage().setScene(scene);
    }

    public void goSignInLibrary(ActionEvent event) throws IOException {

        this.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInLibrary.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInLibraryController guiSignInLibraryController = fxmlLoader.getController();
        guiSignInLibraryController.startSignIn();

        Scene scene = new Scene(root);

        Main.getStage().setScene(scene);
    }

    public void close()
    {
        this.popup.hide();
    }


}
