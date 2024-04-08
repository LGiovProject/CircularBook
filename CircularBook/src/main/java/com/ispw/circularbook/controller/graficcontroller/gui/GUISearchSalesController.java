package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.Bean.SalesBean;
import com.ispw.circularbook.engineering.Bean.SearchSalesBean;
import com.ispw.circularbook.engineering.Enums.Month;
import com.ispw.circularbook.engineering.Enums.TypeOfSales;
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
        List<SalesBean> salesBeanList;
        SearchSalesBean searchSalesBean = new SearchSalesBean(nameLib.getText(),monthSales.getSelectionModel().getSelectedItem(),(TypeOfSales)typeSales.getSelectionModel().getSelectedItem());
        //clearFieldText();
        SearchSalesController searchSalesController = new SearchSalesController();
        salesBeanList = searchSalesController.searchSales(searchSalesBean.getNameLib(), searchSalesBean.getMonth(), searchSalesBean.getTypeOfSales());
        if (salesBeanList.size() != 0) {

            for (SalesBean salesBean1 : salesBeanList) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementSales.fxml"));
                Pane element = fxmlLoader.load();
                GUIElementSaelesController guiElementSaelesController = fxmlLoader.getController();
                guiElementSaelesController.setSalesElement(salesBean1);
                showResult.getChildren().add(element);
            }
        } else {
            Text text = new Text("Nessun elemento trovato con i valori che hai inserito");
            showResult.getChildren().add(text);
        }
    }
        public void clearFieldText()
        {
            nameLib.setText("");
            typeSales.getSelectionModel().select(0);
            monthSales.getSelectionModel().select(0);
        }


}
