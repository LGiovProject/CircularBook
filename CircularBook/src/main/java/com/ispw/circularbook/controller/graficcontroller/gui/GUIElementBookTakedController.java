package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxMessageSupport;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GUIElementBookTakedController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text usernameGiver;
    @FXML
    Text daysRemaing;
    @FXML
    Button returnBook;

    private BookModel bookModel;

    public void startSetElementTakedBook(ElementBean elementBean)
    {

        bookModel = this.getBookModel(elementBean.getId());
        returnBook.setVisible(false);
        returnBook.setManaged(false);
        if(bookModel.getTypeOfDisponibility()==1)
            this.setLendedBook();
        else
            this.setGiftedBook();

    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : Session.getCurrentSession().getUser().getListBookTaked())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    public void returnBook()
    {
        BoxMessageSupport.PopUpsExcpetionMessage("Non ancora implementato");
    }

    private void setLendedBook(){

        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        usernameGiver.setText("L'hai preso da "+bookModel.getUsername());
        daysRemaing.setText("Rimangono "+bookModel.getDaysRemaing()+" giorni");
        returnBook.setVisible(true);
        returnBook.setManaged(true);
    }

    private void setGiftedBook(){

        title.setText(bookModel.getTitolo());
        author.setText(bookModel.getAutore());
        usernameGiver.setText("L'hai preso da "+bookModel.getUsername());
        daysRemaing.setText("E' stato preso in prestito");
    }


}
