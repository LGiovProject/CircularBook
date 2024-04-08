package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.Session.ControllerSession;
import com.ispw.circularbook.engineering.Session.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.io.IOException;

public class GUIMoreInfoBookController {

    @FXML
    Text author;
    @FXML
    Text title;
    @FXML
    Text argument;
    @FXML
    Text nPage;
    @FXML
    TextArea comment;

    Object object;


    public void setInfoBook(String author,String title, String argument,String npage,String comment,Object ob)
    {
        this.author.setText(author);
        this.title.setText(title);
        this.argument.setText(argument);
        this.nPage.setText(npage);
        this.comment.setText(comment);
        this.comment.setEditable(false);
        this.object=ob;
    }

    public void backButton() throws IOException {

        GUIHomepageController guiHomepageController;
      if(object instanceof GUIElementBookPersonalController)
      {
          GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;
          FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
          Pane pane = fxmlLoader.load();
          guiHomepageController = ControllerSession.getGuiHomepageController();
          guiHomepageController.setSideWindow(pane);
          guiWindowElementBookPersonalController = fxmlLoader.getController();
          if(Session.getCurrentSession().getUserBean()!=null) {
              guiWindowElementBookPersonalController.viewBook(Session.getCurrentSession().getUserBean().getBookOwnList());
          }
          else
          {
              guiWindowElementBookPersonalController.viewBook(Session.getCurrentSession().getLibraryBean().getBookOwnList());
          }
      }
      else if(object instanceof GUIElementBookSearchedController)
      {
          FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchBook.fxml"));
          Pane pane= fxmlLoader.load();
          GUISearchBookController guiSearchBookController= fxmlLoader.getController();
          guiSearchBookController.startSetSearch();
          guiHomepageController = ControllerSession.getGuiHomepageController();
          guiHomepageController.setSideWindow(pane);
          guiSearchBookController.setShowResult(Session.getCurrentSession().getUserBean().getBookLastSearch());
      }


    }

    
}
