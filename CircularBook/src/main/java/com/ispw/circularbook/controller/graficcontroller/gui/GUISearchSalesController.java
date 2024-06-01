package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfSales;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.List;

public class GUISearchSalesController {

    @FXML
    VBox showResult;
    @FXML
    TextField nameLib;
    @FXML
    ChoiceBox<TypeOfSales> typeSales;
    @FXML
    ChoiceBox<Month> monthSales;
    @FXML
    ScrollPane scrollPane;

    private Pane currentPane;

    public void setCurrentPane(Pane currentPane){this.currentPane = currentPane;}

    public void startSetSales()
    {

            monthSales.getItems().addAll(Month.values());

            monthSales.getSelectionModel().select(0);

            typeSales.getItems().addAll(TypeOfSales.values());

            typeSales.getSelectionModel().select(0);
            scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            scrollPane.setHvalue(scrollPane.getHmax());
            showResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);


    }
    public void startSearchSales() throws Exception {
        showResult.getChildren().clear();
        List<SalesModel> salesModelList;
        SearchSalesBean searchSalesBean = new SearchSalesBean(nameLib.getText(),monthSales.getSelectionModel().getSelectedItem(),typeSales.getSelectionModel().getSelectedItem());
        //clearFieldText();
        SearchSalesController searchSalesController = new SearchSalesController();
        salesModelList = searchSalesController.searchSales(searchSalesBean);
        Session.getCurrentSession().getUser().setSalesModelList(salesModelList);
        if (!salesModelList.isEmpty())
            this.setShowResult(salesModelList);
         else {
            Text text = new Text("Nessun elemento trovato con i valori che hai inserito");
            showResult.getChildren().add(text);
        }
    }

    private void setShowResult(List<SalesModel> salesModelList) throws Exception {

        for(SalesModel salesModel: salesModelList)
        {
            ElementBean elementBean = new ElementBean(salesModel.getId());
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementSales.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementSaelesController guiElementSaelesController = fxmlLoader.getController();
            guiElementSaelesController.setSalesElement(elementBean);
            guiElementSaelesController.setPreviuosPane(currentPane);
            showResult.getChildren().add(element);
        }
    }

    public void clearFieldText()
    {
            nameLib.setText("");
            typeSales.getSelectionModel().select(0);
            monthSales.getSelectionModel().select(0);
    }


}
