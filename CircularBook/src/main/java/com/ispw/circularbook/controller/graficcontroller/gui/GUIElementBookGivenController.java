package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.List;

public class GUIElementBookGivenController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text usernameGiver;
    @FXML
    Text daysRemaing;

    private BookModel bookModel;

    public void startSetElementGivenBook(ElementBean elementBean)
    {
        bookModel = this.getBookModel(elementBean.getId());
        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        if(bookModel.getTypeOfDisponibility()==1)
            this.setLendedBook();
        else
            this.setGiftedBook();

    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : getListBookGiven())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    private List<BookModel> getListBookGiven()
    {
        return Session.getCurrentSession().getLibrary()==null?Session.getCurrentSession().getUser().getListBookGiven():Session.getCurrentSession().getLibrary().getBookGivenList();

    }

    private void setLendedBook(){

        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        usernameGiver.setText("L'hai dato a "+bookModel.getUsername());
        daysRemaing.setText("Rimangono \n"+bookModel.getDaysRemaing()+" giorni");
    }

    private void setGiftedBook(){

        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        usernameGiver.setText("L'hai dato a"+bookModel.getUsername());
        daysRemaing.setText("E' stato preso in regalo");
    }
}
