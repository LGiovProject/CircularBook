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
    Text daysRemains;

    private BookModel bookModel;

    public void startSetElementGivenBook(ElementBean elementBean)
    {
        bookModel = this.getBookModel(elementBean.getId());
        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        usernameGiver.setText("L'hai dato a "+bookModel.getUsername());
        String daysRemains= bookModel.getTypeOfDisponibility()==1?"Rimangono \n"+bookModel.getDaysRemaing()+" giorni":"E' stato preso in regalo";
        this.daysRemains.setText(daysRemains);

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
}
