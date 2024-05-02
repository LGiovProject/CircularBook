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
