package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class GUIElementSalesPersonalController {

    @FXML
    private Text title;
    @FXML
    private Text nameLib;
    @FXML
    private Text typeOfSales;
    @FXML
    private Text dateStart;
    @FXML
    private Text dateFinish;

    private SalesModel salesModel;

    private Pane element;

    //La pane serve per moreInforSearch
    private Pane previuosPane;

    public void setPreviuosPane(Pane currentPane) {
        this.previuosPane = currentPane;
    }

    //La scene serve per modifySalesElement
    private Scene previousScene;

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    private BookElementSubject bookElementSubject;


    public void setBookElementSubject(BookElementSubject bookElementSubject) {

        this.bookElementSubject=bookElementSubject;
    }

    public void setElementPersonal(ElementBean elementBean){
        this.salesModel=getSalesModel(elementBean.getId());
        this.element= elementBean.getPane();
        this.title.setText(salesModel.getTitle());
        this.nameLib.setText(salesModel.getNameLib());
        this.typeOfSales.setText(salesModel.getTypeOfSalesString());
    }

    public void moreInfoSearch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoSales.fxml"));
        Pane pane = fxmlLoader.load();
        ElementBean elementBean = new ElementBean(salesModel.getId());
        GUIMoreInfoSalesController guiMoreInfoSalesController = fxmlLoader.getController();
        guiMoreInfoSalesController.setInfoSales(elementBean);
        guiMoreInfoSalesController.setPreviousPane(this.previuosPane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    public void modifySalesElement() throws IOException {
        GUIModifyElementSalesController guiModifyElementSalesController;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ModifyElementSales.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        guiModifyElementSalesController =fxmlLoader.getController();

        ElementBean elementBean = new ElementBean(this.element,salesModel.getId());
        guiModifyElementSalesController.setPreviusScene(previousScene);
        guiModifyElementSalesController.setBookElementSubject(bookElementSubject);
        guiModifyElementSalesController.setElement(elementBean);



    }

    public void removeSales(){
        InsertSalesController insertSalesController = new InsertSalesController();
        SalesBean salesBean= new SalesBean(salesModel.getId());
        insertSalesController.removeSales(salesBean);
        bookElementSubject.notifyObserver(this.element);
        MessageSupport.PopUpsSuccessMessage("la sales è stato rimossa correttamente");

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
