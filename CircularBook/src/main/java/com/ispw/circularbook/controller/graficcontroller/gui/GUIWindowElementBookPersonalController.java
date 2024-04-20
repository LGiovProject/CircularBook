package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.factory.concrete.ElementBookPersonalViewFactory;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
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



    public void viewBook( List<BookModel> listBookModel) throws IOException {
        this.viewInitialization();

        setViewBook(listBookModel);
    }

    public void viewSales(List<SalesModel> salesModelList) throws IOException{

        this.viewInitialization();
        for(SalesModel salesModel : salesModelList){

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementSalesPersonal.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementSaelesController guiElementSaelesController = fxmlLoader.getController();
            //Da sistemare
            // guiElementSaelesController.setSalesElementPersonal(sa);
            guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
            guiElementSaelesController.setCurrentScene(guiHomepageController.getCurrentScene());
            viewMyBook.getChildren().add(element);


        }

    }

    public void viewMyLendedBook(List<BookModel> listBookModel) throws IOException {
        this.viewInitialization();
        for (BookModel bookModel : listBookModel) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookTakedController guiElementBookTakedController = fxmlLoader.getController();
            //guiElementBookTakedController.startSetElementTakedBook(bookModel);
            viewMyBook.getChildren().add(element);
        }
    }

    public void viewMyGivenBook(List<BookModel> listBookModel) throws IOException {
        this.viewInitialization();
        for (BookModel bookModel : listBookModel) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
            //guiElementBookGivenController.startSetElementGivenBook(bookModel);
            viewMyBook.getChildren().add(element);
        }
    }

    public void backButton() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
        Pane pane= fxmlLoader.load();
        guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
        guiHomepageController.setSideWindow(pane);
    }

    public void setViewBook(List<BookModel> bookBeansList) throws IOException {
        ElementBookPersonalViewFactory elementBookPersonalViewFactory= new ElementBookPersonalViewFactory();
        for (BookModel bookModel : bookBeansList) {
            FXMLLoader fxmlLoader = elementBookPersonalViewFactory.createFxmlLoader();
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            fxmlLoader.setController(elementBookPersonalViewFactory.createController());
            guiElementBookPersonalController.setBookElement(bookModel,element);
            guiElementBookPersonalController.setBookElementSubject(bookElementSubject);
            guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
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
        guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
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

    private void viewInitialization(){
        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    // public void viewSales()
}


