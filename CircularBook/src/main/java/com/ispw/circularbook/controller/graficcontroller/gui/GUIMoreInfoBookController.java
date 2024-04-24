package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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

    private Pane previousPane;

    public void setInfoBook(ElementBookBean elementBookBean)
    {
        BookModel bookModel = getBookModel(elementBookBean.getId());
        this.author.setText(bookModel.getAutore());
        this.title.setText(bookModel.getTitolo());
        this.argument.setText(bookModel.getArgomentoString());
        this.nPage.setText(bookModel.getNpagineString());
        this.comment.setText(bookModel.getCommento());
        this.comment.setEditable(false);

    }

    public void backButton() throws IOException {

        GUIHomepageController guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
        guiHomepageController.setSideWindow(previousPane);
//      if(object instanceof GUIElementBookPersonalController)
//      {
//          GUIWindowElementBookPersonalController guiWindowElementBookPersonalController;
//          FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WindowElementBookPersonal.fxml"));
//          Pane pane = fxmlLoader.load();
//          guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//          guiHomepageController.setSideWindow(pane);
//          guiWindowElementBookPersonalController = fxmlLoader.getController();
//          if(Session.getCurrentSession().getUser()!=null) {
//              guiWindowElementBookPersonalController.viewBook(Session.getCurrentSession().getUser().getBookOwnList());
//          }
//          else
//          {
//              guiWindowElementBookPersonalController.viewBook(Session.getCurrentSession().getLibrary().getBookOwnList());
//          }
//      }
//      else if(object instanceof GUIElementBookSearchedController)
//      {
//          FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("SearchBook.fxml"));
//          Pane pane= fxmlLoader.load();
//          GUISearchBookController guiSearchBookController= fxmlLoader.getController();
//          guiSearchBookController.startSetSearch();
//          guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//          guiHomepageController.setSideWindow(pane);
//          guiSearchBookController.setShowResult(Session.getCurrentSession().getUser().getBookLastSearch());
//      }


    }

    public void setPreviousPane(Pane previousPane)
    {
        this.previousPane = previousPane;
    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : Session.getCurrentSession().getUser().getLastBookListViewed())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    
}
