package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.Bean.LibraryBean;
import com.ispw.circularbook.engineering.Bean.SalesBean;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Popup;


public class GUIPopUpsMoreInfoSalesController {

    @FXML
    private Text title;
    @FXML
    private Text typeSales;
    @FXML
    private Text nameLibrary;
    @FXML
    private Text dateStart;
    @FXML
    private Text dateFinish;
    @FXML
    private TextArea descriptionSales;
    @FXML
    private Text libraryStret;
    @FXML
    private Text mailLibrary;
    @FXML
    private Text numberLibrary;

    private Popup popup;

    public void setPopUpsMoreInfoSales(SalesBean salesBean, LibraryBean libraryBean, Popup popup){

        this.title.setText(salesBean.getTitlePromotion());
        System.out.println(salesBean.getTypeOfSalesString()+" GUIPopUpsMoreInfoSalesController");
        this.typeSales.setText(salesBean.getTypeOfSalesString());
        this.nameLibrary.setText(salesBean.getNameLib());
        this.dateStart.setText(salesBean.getDateStart());
        this.dateFinish.setText(salesBean.getDateFinish());
        this.descriptionSales.setText(salesBean.getDescription());
        this.libraryStret.setText(libraryBean.getVia());
        this.mailLibrary.setText(libraryBean.getEmail());
        this.numberLibrary.setText(String.valueOf(libraryBean.getTelNumber()));
        System.out.println(salesBean.getDescription()+" GUIPopUpsMoreInfoSalesController");
        this.descriptionSales.setEditable(false);
        this.popup=popup;

    }

    public void close()
    {
        this.popup.hide();
    }
}
