package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.SalesModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class GUIModifyElementSalesController {

    @FXML
    TextField titleSales;
    @FXML
    TextField libreria;
    @FXML
    DatePicker dateStart;
    @FXML
    DatePicker dateFinish;
    @FXML
    TextArea descrizione;
    @FXML
    RadioButton sales;
    @FXML
    RadioButton event;
    @FXML
    ImageView titleImageView;
    @FXML
    ImageView libraryImageView;
    @FXML
    ImageView descriptionImageView;




    private Scene previusScene;

    public void setPreviusScene(Scene scene){previusScene=scene;}

    private BookElementSubject bookElementSubject;


    SalesModel salesModel;

    public void setBookElementSubject(BookElementSubject bookElementSubject) {
        this.bookElementSubject = bookElementSubject;
    }

    private final Boolean[] rwField= {true,true,true};

    public void setElement(ElementBean elementBean)
    {
        salesModel=getSalesModel(elementBean.getId());
        this.titleSales.setEditable(false);
        this.libreria.setEditable(false);
        this.descrizione.setEditable(false);
        this.titleSales.setText(salesModel.getTitle());
        this.libreria.setText(salesModel.getNameLib());
        this.descrizione.setText(salesModel.getDescription());
        setTypeOfDisponibility(salesModel.getTypeOfSalesInt());
        setDateStart(salesModel.getDateStart());
        setDateFinish(salesModel.getDateFinish(),salesModel.getDateStart());


    }

    public int getTypeOfDisponibility() {
        if(this.event.isSelected())
        {
            return 2;
        }
        else if(this.sales.isSelected())
        {
            return 1;
        }
        return 0;
    }

    public void applyModify(){
        InsertSalesController insertSalesController= new InsertSalesController();
        insertSalesController.updateSales(new SalesBean(salesModel.getId(),this.titleSales.getText(),this.descrizione.getText(),this.dateStart.getValue(),this.dateFinish.getValue()));

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
                    titleSales.setEditable(true);
                    titleSales.setStyle(onStyle);
                    titleImageView.setImage(checkBoxImage);
                    rwField[0] = false;

                }else
                {
                    titleSales.setEditable(false);
                    titleSales.setStyle(offStyle);
                    titleImageView.setImage(pencilImage);
                    titleSales.setText(titleSales.getText());
                    rwField[0]=true;
                }
                break;

            case "libraryButton":

                if(rwField[1])
                {
                    libreria.setEditable(true);
                    libreria.setStyle(onStyle);
                    libraryImageView.setImage(checkBoxImage);
                    rwField[1]=false;
                }else
                {
                    libreria.setEditable(false);
                    libreria.setStyle(offStyle);
                    libraryImageView.setImage(pencilImage);
                    libreria.setText(libreria.getText());
                    rwField[1]=true;
                }
                break;
            case "descriptionButton":
                if(rwField[2])
                {
                    descrizione.setEditable(true);
                    descrizione.setStyle(textAreaStyleOn);
                    descriptionImageView.setImage(checkBoxImage);
                    rwField[2]=false;
                }else
                {
                    descrizione.setEditable(false);
                    descrizione.setStyle(textAreaStyleOff);
                    descriptionImageView.setImage(pencilImage);
                    descrizione.setText(descrizione.getText());
                    rwField[2]=true;
                }
                break;
            default:


        }
    }

    private void setDateStart(LocalDate dateStart)
    {
        this.dateStart.setDayCellFactory(getDayCellFactory(LocalDate.now()));
        this.dateStart.setValue(dateStart);
    }

    private void setDateFinish(LocalDate dateFinish, LocalDate dateStart)
    {
        this.dateFinish.setDayCellFactory(getDayCellFactory(dateStart));
        this.dateFinish.setValue(dateFinish);
    }

    public void backButton() {
        Main.getStage().setScene(this.previusScene);

    }

    private Callback<DatePicker, DateCell> getDayCellFactory(LocalDate minDate) {
        return datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item.isBefore(minDate)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;"); // Colore di sfondo per le date disabilitate
                }
            }
        };
    }

    private void setTypeOfDisponibility(int typeOfDisponibility)
    {
        if(typeOfDisponibility==1)
        {
            this.sales.setSelected(true);
            this.event.setSelected(false);
        }
        else
        {
            this.event.setSelected(true);
            this.sales.setSelected(false);
        }
    }

    private SalesModel getSalesModel(int id){
        for(SalesModel salesModel : getSalesListSession())
        {
            if(salesModel.getId()==id)
                return salesModel;
        }
        return null;
    }

    private List<SalesModel> getSalesListSession()
    {
        return Session.getCurrentSession().getLibrary().getSalesModelList();
    }


}
