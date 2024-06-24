package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

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

    public void setPreviousPane(Pane previousPane)
    {
        this.previousPane = previousPane;
    }

    public void setInfoBook(ElementBean elementBean)
    {
        BookModel bookModel = getBookModel(elementBean.getId());
        this.author.setText(bookModel.getAutore());
        this.title.setText(bookModel.getTitolo());
        this.argument.setText(bookModel.getArgomentoString());
        this.nPage.setText(bookModel.getNpagineString());
        this.comment.setText(bookModel.getCommento());
        this.comment.setEditable(false);
    }

    public void backButton() throws IOException {

        Session.getCurrentSession().getSceneFacade().loadScene(previousPane);

//        GUIHomepageController guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(previousPane);
    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : getListBookModel())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    private List<BookModel> getListBookModel()
    {
        return Session.getCurrentSession().getUser()!=null?Session.getCurrentSession().getUser().getBookLastViewedList():Session.getCurrentSession().getLibrary().getBookOwnList();
    }

    
}
