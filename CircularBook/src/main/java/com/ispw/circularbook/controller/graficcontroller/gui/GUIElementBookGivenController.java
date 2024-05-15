package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GUIElementBookGivenController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text emailTaker;
    @FXML
    Text daysRemaing;

    public void startSetElementGivenBook(ElementBookBean elementBookBean)
    {
        BookModel bookModel = this.getBookModel(elementBookBean.getId());
        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        emailTaker.setText("E' stato preso da "+bookModel.getEmailTaker());
        daysRemaing.setText("Rimangono "+bookModel.getDaysRemaing()+" giorni");
    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : Session.getCurrentSession().getUser().getListBookGiven())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }
}
