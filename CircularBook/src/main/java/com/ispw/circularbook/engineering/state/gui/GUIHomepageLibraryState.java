package com.ispw.circularbook.engineering.state.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageSideButtonLibraryController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUISettingLibraryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageLibraryState implements GUIHomepageState {
    @Override
    public void startHomepage(GUIHomepageController context) throws IOException {
        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonLibrary.fxml"));
        Pane screenA = fxmlLoaderA.load();
        GUIHomepageSideButtonLibraryController guiHomepageSideButtonLibraryController = fxmlLoaderA.getController();
        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
        Pane screenB = fxmlLoaderB.load();

        context.setSideButton(screenA);
        context.setSideWindow(screenB);

        guiHomepageSideButtonLibraryController.setPreviuosScene(context.getCurrentScene());
    }

    @Override
    public void setting(GUIHomepageController context) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingLibrary.fxml"));
        Parent root =fxmlLoader.load();
        GUISettingLibraryController guiSettingLibraryController;
        guiSettingLibraryController =fxmlLoader.getController();
        guiSettingLibraryController.startSetting();
        guiSettingLibraryController.setPreviousScene(context.getCurrentScene());
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
    }
}
