package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.Bean.BookBean;
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

    public void startSetElementGivenBook(BookBean bookBean)
    {
        title.setText(bookBean.getTitolo());
        author.setText(bookBean.getAutore());
        emailTaker.setText("E' stato preso da "+bookBean.getEmailInfo());
        daysRemaing.setText("Rimangono "+bookBean.getDaysRemaing()+" giorni");
    }
}
