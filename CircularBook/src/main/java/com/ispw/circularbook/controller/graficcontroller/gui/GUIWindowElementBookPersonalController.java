package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.session.ControllerSession;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.List;

public class GUIWindowElementBookPersonalController implements Observer{
    @FXML
    VBox viewMyBook;
    @FXML
    ScrollPane scrollPane;

    private GUIHomepageController guiHomepageController;



    public void viewBook( List<BookBean> listBookBean) throws IOException {
        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        setViewBook(listBookBean);
    }

    public void viewSales(List<SalesBean> salesBeanList) throws IOException{

        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        for(SalesBean salesBean : salesBeanList){

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementSalesPersonal.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementSaelesController guiElementSaelesController = fxmlLoader.getController();
            guiElementSaelesController.setSalesElementPersonal(salesBean);
            guiHomepageController= ControllerSession.getGuiHomepageController();
            guiElementSaelesController.setCurrentScene(guiHomepageController.getCurrentScene());
            viewMyBook.getChildren().add(element);


        }

    }

    public void viewMyLendedBook(List<BookBean> listBookBean) throws IOException {
        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        for (BookBean bookBean : listBookBean) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookTakedController guiElementBookTakedController = fxmlLoader.getController();
            guiElementBookTakedController.startSetElementTakedBook(bookBean);
            viewMyBook.getChildren().add(element);
        }
    }

    public void viewMyGivenBook(List<BookBean> listBookBean) throws IOException {
        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        for (BookBean bookBean : listBookBean) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
            guiElementBookGivenController.startSetElementGivenBook(bookBean);
            viewMyBook.getChildren().add(element);
        }
    }

    public void backButton() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
        Pane pane= fxmlLoader.load();
        guiHomepageController= ControllerSession.getGuiHomepageController();
        guiHomepageController.setSideWindow(pane);
    }

    public void setViewBook(List<BookBean> bookBeansList) throws IOException {
        for (BookBean bookBean : bookBeansList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
            guiElementBookPersonalController.setBookElement(bookBean,element);
            guiElementBookPersonalController.setBookElementSubject(bookElementSubject);
            guiHomepageController= ControllerSession.getGuiHomepageController();
            guiElementBookPersonalController.setCurrentScene(guiHomepageController.getCurrentScene());
            viewMyBook.getChildren().add(element);
        }
    }
    @Override
    public void update(Object object1 , Object object2) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
        Pane element = new Pane();
        try {
            element = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
        guiElementBookPersonalController.setBookElement((BookBean) object1,element);
        guiHomepageController= ControllerSession.getGuiHomepageController();
        guiElementBookPersonalController.setCurrentScene(guiHomepageController.getCurrentScene());
        int index;
        index=viewMyBook.getChildren().indexOf((Pane)object2);
        viewMyBook.getChildren().set(index,element);

    }

    @Override
    public void remove(Object object1) {

        int index;
        index=viewMyBook.getChildren().indexOf((Pane)object1);
        viewMyBook.getChildren().remove(index);

    }

    // public void viewSales()
}


