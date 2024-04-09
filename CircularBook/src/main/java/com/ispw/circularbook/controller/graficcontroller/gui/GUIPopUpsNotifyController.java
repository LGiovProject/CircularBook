package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.NotifyBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class GUIPopUpsNotifyController {

    @FXML
    private VBox viewNotify;

    public void setViewNotify(List<NotifyBean> notifyBeanList) throws IOException {
        viewNotify.getChildren().clear();
        int i=0;
        for(NotifyBean notifyBean: notifyBeanList)
        {
            i++;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementNotify.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementNotifyController guiElementNotifyController = fxmlLoader.getController();
            guiElementNotifyController.setMessageNotify(notifyBean.getMessage(),i);
            viewNotify.getChildren().add(element);
        }
    }


}
