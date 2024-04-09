package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.mysql.cj.util.StringUtils;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GUIModifyElementBookController {
    @FXML
    Text oldTitle;
    @FXML
    Text oldAuthor;
    @FXML
    Text oldArgument;
    @FXML
    Text oldNpage;
    @FXML
    TextArea oldComment;
    @FXML
    Text oldTypeOfDisponibility;

    @FXML
    TextField newTitle;
    @FXML
    TextField newAuthor;
    @FXML
    TextField newArgument;
    @FXML
    TextField newNpage;
    @FXML
    TextArea newComment;
    @FXML
    RadioButton gifter;
    @FXML
    RadioButton lender;

    private String title;
    private String author;
    private String argument;
    private String nPage;
    private String comment;

    private int id;

    private Scene previusScene;

    public Scene getPreviusScene() {
        return previusScene;
    }

    public void setPreviusScene(Scene currentScene) {
        this.previusScene = currentScene;
    }

    public void setElement(BookBean bookBean)
    {
        this.id=bookBean.getId();
        this.oldTitle.setText(bookBean.getTitolo());
        this.oldAuthor.setText(bookBean.getAutore());
        this.oldArgument.setText(bookBean.getArgomentoString());
        this.oldNpage.setText(bookBean.getNpagineString());
        this.oldComment.setText(bookBean.getCommento());
        this.oldComment.setEditable(false);
        this.oldTypeOfDisponibility.setText(bookBean.getTypeOfDisponibilityString());
    }
/*
    public void applyModify()  {
        InsertBookController insertBookController = new InsertBookController();
        try {
            takeTextField();
            BookBean bookBean = new BookBean(this.id,TakeBeanFromList.getEmailFromCurrentSession(), getTypeOfDisponibility(),title,author, argument,title, newNpage.getText(), newComment.getText());
            insertBookController.updateBookInfo(bookBean);
            clearField();

        }catch (WrongNpageFormatException e){
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }*/

    public int getTypeOfDisponibility()
    {
        if(this.gifter.isSelected())
        {
            return 2;
        }
        else if(this.lender.isSelected())
        {
            return 1;
        }
        return 0;
    }



    private void clearField()
    {
        this.newTitle.setText("");
        this.newArgument.setText("");
        this.newAuthor.setText("");
        this.newComment.setText("");
        this.newNpage.setText("");
    }
    private void takeTextField()
    {


        title=StringUtils.isEmptyOrWhitespaceOnly(newTitle.getText())?oldTitle.getText():newTitle.getText();
        argument=StringUtils.isEmptyOrWhitespaceOnly(newArgument.getText())?oldArgument.getText():newArgument.getText();


        if(StringUtils.isEmptyOrWhitespaceOnly(newAuthor.getText()))
        {
            author=oldAuthor.getText();
        }
        else
        {
            author=newAuthor.getText();
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(newNpage.getText()))
        {
            nPage=oldNpage.getText();
        }
        else
        {
            nPage=newNpage.getText();
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(newComment.getText()))
        {
            comment=newComment.getText();
        }
        else
        {
            comment=newComment.getText();
        }
    }

    public void backButton()
    {
        Main.getStage().setScene(this.previusScene);
    }
}
