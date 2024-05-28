package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.utils.TakeBeanFromList;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;
import com.ispw.circularbook.model.BookModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class GUIModifyElementBookController {
    @FXML
    TextField title;
    @FXML
    TextField author;
    @FXML
    Text argument;
    @FXML
    TextField nPage;
    @FXML
    TextArea comment;
    @FXML
    TextField typeOfDisponibility;
    @FXML
    RadioButton gifter;
    @FXML
    RadioButton lender;
    @FXML
    ImageView titleImageView;
    @FXML
    ImageView authorImageView;
    @FXML
    ImageView argumentImageView;
    @FXML
    ImageView nPageImageView;
    @FXML
    ImageView commentImageView;
    @FXML
    ChoiceBox<Arguments> argumentChoiceBox;

    private Pane panel;

    private final Boolean[] rwField= {true,true,true,true,true};

    private int id;

    private BookBean bookBean;

    private BookElementSubject bookElementSubject;

    private Scene previusScene;

    public void setPreviusScene(Scene currentScene) {
        this.previusScene = currentScene;
    }

    public BookElementSubject getBookElementSubject() {
        return bookElementSubject;
    }

    public void setBookElementSubject(BookElementSubject bookElementSubject){
        this.bookElementSubject = bookElementSubject;
    }

    public void setElement(ElementBean elementBean){
        BookModel bookModel = this.getBookModel(elementBean.getId());
        this.panel= elementBean.getPane();
        this.title.setEditable(false);
        this.author.setEditable(false);
        this.nPage.setEditable(false);
        this.comment.setEditable(false);
        this.title.setText(bookModel.getTitolo());
        this.author.setText(bookModel.getAutore());
        setArgument(bookModel.getArgomento());
        this.nPage.setText(bookModel.getNpagineString());
        this.comment.setText(bookModel.getCommento());
        this.typeOfDisponibility.setText(bookModel.getTypeOfDisponibilityString());
        setTypeOfDisponibility(bookModel.getTypeOfDisponibility());
        argumentChoiceBox.getItems().addAll(Arguments.values());
        argumentChoiceBox.getSelectionModel().select(bookModel.getArgomento());
        argumentChoiceBox.setVisible(false);
        if(previusScene==null)
            System.out.println("GUIModifyElementBookController.setElement() C'è un grosso problema!!");


    }

    private void setArgument(Arguments arguments){
        if(arguments==Arguments.Any)
        {
            this.argument.setText("Inserisci Argomento");
        }
        else
        {
            this.argument.setText(arguments.getArgument());
        }
    }

    public void applyModify(){
        InsertBookController insertBookController = new InsertBookController();
        try {
            BookBean bookBean = new BookBean(this.id,TakeBeanFromList.getEmailFromCurrentSession(), getTypeOfDisponibility(),title.getText(),author.getText(), argument.getText(), nPage.getText(), comment.getText());
            insertBookController.updateBookInfo(bookBean);
            this.bookElementSubject.notifyObserver(bookBean,panel);
            BoxExcpetionMessage.PopUpsExcpetionMessage("Modifiche salvate");
        }catch (WrongNpageFormatException e){
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public int getTypeOfDisponibility(){
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

    public void rewriteField(ActionEvent event) throws FileNotFoundException {
        FileInputStream inputPencil = new FileInputStream("src/main/resources/com/ispw/circularbook/img/PencilModify.png");
        FileInputStream inputCheckBox = new FileInputStream("src/main/resources/com/ispw/circularbook/img/ConfirmModifyRed.png");
        Image checkBoxImage = new Image(inputCheckBox);
        Image pencilImage = new Image(inputPencil);
        String onStyle="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";
        String offStyle="fx-border: none; -fx-background-color:none;";
        String textAreaStyleOn="text-area-background: white ;";
        String textAreaStyleOff="text-area-background: #F1C9A0 ;";
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "titleButton":

                if (rwField[0]) {
                    title.setEditable(true);
                    title.setStyle(onStyle);
                    titleImageView.setImage(checkBoxImage);
                    rwField[0] = false;

                }else
                {
                    title.setEditable(false);
                    title.setStyle(offStyle);
                    titleImageView.setImage(pencilImage);
                    title.setText(title.getText());
                    rwField[0]=true;
                }
                break;

            case "authorButton":

                if(rwField[1])
                {
                    author.setEditable(true);
                    author.setStyle(onStyle);
                    authorImageView.setImage(checkBoxImage);

                    rwField[1]=false;
                }else
                {
                    author.setEditable(false);
                    author.setStyle(offStyle);
                    authorImageView.setImage(pencilImage);
                    author.setText(author.getText());
                    rwField[1]=true;
                }
                break;

            case "argumentButton":
                if(rwField[2])
                {

                    argumentChoiceBox.setVisible(true);
                    argumentImageView.setImage(checkBoxImage);

                    rwField[2]=false;
                }else
                {

                    argumentImageView.setImage(pencilImage);
                    argument.setText(argumentChoiceBox.getSelectionModel().getSelectedItem().getArgument());
                    argumentChoiceBox.setVisible(false);
                    rwField[2]=true;
                }
                break;
            case "nPageButton":
                if(rwField[3])
                {
                    nPage.setEditable(true);
                    nPage.setStyle(onStyle);
                    nPageImageView.setImage(checkBoxImage);

                    rwField[3]=false;
                }else
                {
                    nPage.setEditable(false);
                    nPage.setStyle(offStyle);
                    nPageImageView.setImage(pencilImage);
                    nPage.setText(nPage.getText());
                    rwField[3]=true;
                }
                break;
            case "commentButton":
                if(rwField[4])
                {
                    comment.setEditable(true);
                    comment.setStyle(textAreaStyleOn);
                    commentImageView.setImage(checkBoxImage);

                    rwField[4]=false;
                }else
                {
                    comment.setEditable(false);
                    comment.setStyle(textAreaStyleOff);
                    commentImageView.setImage(pencilImage);
                    comment.setText(comment.getText());
                    rwField[4]=true;
                }
                break;
            default:


        }
    }

    public void backButton() {
        Main.getStage().setScene(this.previusScene);

    }

    private void setTypeOfDisponibility(int typeOfDisponibility){
        if(typeOfDisponibility==1)
        {
            this.lender.setSelected(true);
            this.gifter.setSelected(false);
        }
        else
        {
            this.gifter.setSelected(true);
            this.lender.setSelected(false);
        }
    }

    private BookModel getBookModel(int id){
        for(BookModel bookModel : getBookListSession())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }
        return null;
    }

    private List<BookModel> getBookListSession(){
        return Session.getCurrentSession().getLibrary()==null?Session.getCurrentSession().getUser().getBookOwnList():Session.getCurrentSession().getLibrary().getBookOwnList();
    }


}
