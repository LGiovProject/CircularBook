package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIPopUpsExceptionController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIPopUpsGuestDeniedController;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;

import javafx.stage.Popup;



import java.io.IOException;


public class MessageSupport {


     public static void PopUpsExcpetionMessage(String message){
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsMessage.fxml"));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
             guiPopUpsExceptionController.setPopup(popup,message);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             throw new RuntimeException(e);
         }
     }

     public static void PopUpsSuccessMessage(String message)
     {
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsMessage.fxml"));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
             guiPopUpsExceptionController.setPopup(popup,message);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             throw new RuntimeException(e);
         }
     }

     public static void PopUpsGuestDeniedMessage()
     {
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsGuestDenied.fxml"));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsGuestDeniedController guiPopUpsGuestDeniedController = fxmlLoader.getController();
             guiPopUpsGuestDeniedController.setPopup(popup);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             throw new RuntimeException(e);
         }
     }


     public static void cliExceptionSMessage(String exception)
     {
         System.out.println("\n**************************\n");
         System.out.println(exception);
         System.out.println("\n**************************\n");
     }





}
