package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



import java.io.IOException;

public class GUISignInController {

    private Scene currentScene;
    private Scene previuosScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void goSignInUser() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInUser.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInUserController guiSignInUserController= fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiSignInUserController.startSignIn(previuosScene,currentScene);
        Main.getStage().setScene(scene);
    }

    public void goSignInLibrary() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInLibrary.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInLibraryController guiSignInLibraryController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiSignInLibraryController.startSignIn(previuosScene,currentScene);
        Main.getStage().setScene(scene);
    }

    public void goBack() throws IOException {
        Main.getStage().setScene(previuosScene);
    }


}
