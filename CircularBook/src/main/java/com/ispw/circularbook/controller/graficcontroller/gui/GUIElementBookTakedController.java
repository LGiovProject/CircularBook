package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
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

    public void startSetElementTakedBook(BookBean bookBean)
    {
        title.setText(bookBean.getTitolo());
        author.setText(bookBean.getAutore());
        emailGiver.setText("L'hai preso da "+bookBean.getEmailInfo());
        daysRemaing.setText("Rimangono "+bookBean.getDaysRemaing()+" giorni");

    }
}
