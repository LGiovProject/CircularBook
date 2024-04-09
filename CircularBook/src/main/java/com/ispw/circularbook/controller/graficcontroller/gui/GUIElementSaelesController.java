package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.LibraryController;
import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import java.io.IOException;

public class GUIElementSaelesController {

    @FXML
    private Text title;
    @FXML
    private Text nameLib;
    @FXML
    private Text type_of_sales;
    @FXML
    private Text date_start;
    @FXML
    private Text date_finish;

    private Scene currentScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    private SalesBean salesBean;

    public void setSalesElement(SalesBean salesBean)
    {
       this.salesBean=salesBean;
       this.title.setText(salesBean.getTitlePromotion());
       this.nameLib.setText(salesBean.getNameLib());

    }

    public void setSalesElementPersonal(SalesBean salesBean){
        this.salesBean=salesBean;
        this.title.setText(salesBean.getTitlePromotion());
        this.type_of_sales.setText(salesBean.getTypeOfSalesString());
        this.date_start.setText(salesBean.getDateStart());
        this.date_finish.setText(salesBean.getDateFinish());

    }

    public void moreInfo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsMoreInfoSales.fxml"));
        LibraryController libraryController = new LibraryController();
        LibraryBean libraryBean = libraryController.searchLibrary(salesBean.getEmail());
        Popup popup = new Popup();
        Label label = fxmlLoader.load();
        GUIPopUpsMoreInfoSalesController guiPopUpsMoreInfoSalesController = fxmlLoader.getController();
        guiPopUpsMoreInfoSalesController.setPopUpsMoreInfoSales(salesBean,libraryBean,popup);
        popup.getContent().add(label);
        popup.setAutoHide(true);
        popup.show(Main.getStage());
    }
}
