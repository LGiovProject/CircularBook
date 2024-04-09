package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.enums.TypeOfSales;

import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class GUIInsertSalesController {


    @FXML
    TextField titleSales;
    @FXML
    TextArea descriptionSales;
    @FXML
    DatePicker dateStart;
    @FXML
    DatePicker dateFinish;
    @FXML
    RadioButton promotionsRadioButton;
    @FXML
    RadioButton eventsRadioButton;

    public void insertSales()
    {
        try {
            SalesBean salesBean = new SalesBean(Session.getCurrentSession().getLibraryBean().getEmail(), Session.getCurrentSession().getLibraryBean().getNomeLib(), titleSales.getText(), typeOfSales(), descriptionSales.getText(), dateStart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), dateFinish.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            InsertSalesController insertSalesController = new InsertSalesController();
            insertSalesController.insertSales(salesBean);
            clearCamp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TypeOfSales typeOfSales()
    {
        if(promotionsRadioButton.isSelected())
            return TypeOfSales.Promotion;
        else if(eventsRadioButton.isSelected())
            return TypeOfSales.Event;
        else
            return null;
    }

    private void clearCamp()
    {
        titleSales.setText("");
        descriptionSales.setText("");
        promotionsRadioButton.setSelected(false);
        eventsRadioButton.setSelected(false);
        dateStart.setValue(null);
        dateFinish.setValue(null);
    }

}
