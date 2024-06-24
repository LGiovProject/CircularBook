package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.engineering.utils.TakeBeanFromList;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIInsertLendBookController {
    @FXML
    private TextField titleTField;
    @FXML
    private ChoiceBox<Arguments> argumentChBox;
    @FXML
    private TextField nPageTField;
    @FXML
    private TextField authorTField;
    @FXML
    private TextField editorTField;
    @FXML
    private TextArea commentTArea;


    public void startRegisterBook()
    {
        argumentChBox.getItems().addAll(Arguments.values());
        argumentChBox.getSelectionModel().select(0);
    }

    public void registerBook() {
        try{
            RegistrationBookBean registrationBookBean= new RegistrationBookBean(TakeBeanFromList.getEmailFromCurrentSession(),1,titleTField.getText(),authorTField.getText(),argumentChBox.getSelectionModel().getSelectedItem(),nPageTField.getText(),commentTArea.getText());
            InsertBookController insertBookController = new InsertBookController();
            insertBookController.registerBook(registrationBookBean);
            clearTextField();
            MessageSupport.PopUpsSuccessMessage("la registrazione è avvenuta con successo");
        }catch (TitleCampRequiredException|WrongNpageFormatException e){
            MessageSupport.PopUpsExceptionMessage(e.getMessage());
        }

    }
    public void clearTextField()
    {
        titleTField.setText("");
        argumentChBox.getSelectionModel().select(0);
        nPageTField.setText("");
        authorTField.setText("");
        commentTArea.setText("");
        editorTField.setText("");
    }


}
