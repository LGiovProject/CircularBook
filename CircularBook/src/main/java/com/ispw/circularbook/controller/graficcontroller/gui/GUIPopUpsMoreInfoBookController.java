package com.ispw.circularbook.controller.graficcontroller.gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.awt.event.ActionEvent;

public class GUIPopUpsMoreInfoBookController {

    @FXML
    Text author;
    @FXML
    Text title;
    @FXML
    Text argument;
    @FXML
    Text npage;
    @FXML
    Text dateInsert;
    @FXML
    TextArea comment;

    private Popup popup;


    public void moreInfoBook(String author,String title, String argument,String npage,String comment,Popup popup)
    {
        this.author.setText(author);
        this.title.setText(title);
        this.argument.setText(argument);
        this.npage.setText(npage);
        this.comment.setText(comment);
        this.comment.setEditable(false);
        this.popup=popup;
    }

    public void close() {

        this.popup.hide();
    }


}
