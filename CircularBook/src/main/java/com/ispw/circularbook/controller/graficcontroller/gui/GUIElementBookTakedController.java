package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GUIElementBookTakedController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text emailGiver;
    @FXML
    Text daysRemaing;

    public void startSetElementTakedBook(ElementBookBean elementBookBean)
    {
        BookModel bookModel = this.getBookModel(elementBookBean.getId());
        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        emailGiver.setText("L'hai preso da "+bookModel.getEmailGiver());
        daysRemaing.setText("Rimangono "+bookModel.getDaysRemaing()+" giorni");

    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : Session.getCurrentSession().getUser().getListBookTaked())
        {
            System.out.println("Ci sono entrato GUIElementBookTakedController.startSetElementTakedBook/getBookModel\n");
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }
}
