package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIPopUpsExceptionController;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;

import javafx.stage.Popup;



import java.io.IOException;


public class BoxExcpetionMessage {


     public static void PopUpsExcpetionMessage(String message){
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsException.fxml"));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
             guiPopUpsExceptionController.setPopup(popup,message);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             e.printStackTrace();
         }
     }





}
