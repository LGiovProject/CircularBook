package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class GUIMoreInfoSalesController {
    @FXML
    Text title;
    @FXML
    Text libreria;
    @FXML
    Text tipologia;
    @FXML
    Text dataInizio;
    @FXML
    Text dataFine;
    @FXML
    TextArea descrizione;

    SalesModel salesModel;

    private Pane previousPane;

    public void setPreviousPane(Pane previousPane)
    {
        this.previousPane = previousPane;
    }

    public void setInfoSales(ElementBean elementBean)
    {
        salesModel = getSalesModel(elementBean.getId());
        this.title.setText(salesModel.getTitle());
        this.libreria.setText(salesModel.getNameLib());
        this.tipologia.setText(salesModel.getTypeOfSalesString());
        this.dataInizio.setText(salesModel.getDateStartString());
        this.dataFine.setText(salesModel.getDateFinishString());
    }

    public void backButton() throws IOException {

        if(previousPane==null)
            System.out.println("GUIMoreInfoSalesController.backButton() E' un problema!!!");
        Session.getCurrentSession().getSceneFacade().loadScene(previousPane);

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
        return Session.getCurrentSession().getLibrary()==null?Session.getCurrentSession().getUser().getSalesModelList():Session.getCurrentSession().getLibrary().getSalesModelList();

    }
}
