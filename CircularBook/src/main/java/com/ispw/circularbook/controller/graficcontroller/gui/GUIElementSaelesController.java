package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.LibraryController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import java.io.IOException;
import java.util.List;

public class GUIElementSaelesController {

    @FXML
    private Text title;
    @FXML
    private Text nameLib;
    @FXML
    private Text typologie;

    private Pane previuosPane;

    public Pane getPreviuosPane() {
        return previuosPane;
    }

    public void setPreviuosPane(Pane currentPane) {
        this.previuosPane = currentPane;
    }

    private SalesModel salesModel;



    public void setSalesElement(ElementBean elementBean)
    {

       salesModel = getSalesModel(elementBean.getId());
       this.title.setText(salesModel.getTitle());
       this.nameLib.setText(salesModel.getNameLib());
       this.typologie.setText(salesModel.getTypeOfSalesString());

    }

    public void moreInfo() throws IOException {
        ElementBean elementBean =new  ElementBean(salesModel.getId());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoSales.fxml"));
        Pane pane = fxmlLoader.load();
        GUIMoreInfoSalesController guiMoreInfoSalesController = fxmlLoader.getController();
        guiMoreInfoSalesController.setInfoSales(elementBean);
        guiMoreInfoSalesController.setPreviousPane(this.previuosPane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    private SalesModel getSalesModel(int id)
    {
        for(SalesModel salesModel : getBookListSession())
        {
            if(salesModel.getId()==id)
                return salesModel;
        }

        return null;
    }

    private List<SalesModel> getBookListSession()
    {
        return Session.getCurrentSession().getLibrary()==null?Session.getCurrentSession().getUser().getSalesModelList():Session.getCurrentSession().getLibrary().getSalesModelList();
    }
}
