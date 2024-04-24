package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
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

    private Pane currentPane;

    public void viewBook() throws IOException {
        this.viewInitialization();

        List<BookModel> bookModelList = Session.getCurrentSession().getUser().getBookOwnList();
        for (BookModel bookModel : bookModelList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
            ElementBookBean elementBookBean = new ElementBookBean(element, bookModel.getId());
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            guiElementBookPersonalController.setBookElement(elementBookBean);
            guiElementBookPersonalController.setPreviuosPane(currentPane);
            guiElementBookPersonalController.setBookElementSubject(bookElementSubject);
            guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
            guiElementBookPersonalController.setCurrentScene(guiHomepageController.getCurrentScene());
            viewMyBook.getChildren().add(element);
        }
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

    public void viewMyLendedBook() throws IOException {

        this.viewInitialization();
        List<BookModel> listBookModel= Session.getCurrentSession().getUser().getListBookTaked();

        if (listBookModel!=null && !listBookModel.isEmpty()) {
            for (BookModel bookModel : listBookModel) {
                System.out.println("Ci sono entrato GUIWindowElementBookPersonalController.viewMyLendedBook\n");
                ElementBookBean elementBookBean = new ElementBookBean(bookModel.getId());

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));
                Pane element = fxmlLoader.load();
                GUIElementBookTakedController guiElementBookTakedController= fxmlLoader.getController();

                guiElementBookTakedController.startSetElementTakedBook(elementBookBean);

                BookElementSubject bookElementSubject = new BookElementSubject();
                bookElementSubject.register(this);
                viewMyBook.getChildren().add(element);
            }
        }else
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage("Non hai nessun libro preso in prestito");
        }
    }

    public void viewMyGivenBook() throws IOException {
        this.viewInitialization();
        List<BookModel> bookModelList = Session.getCurrentSession().getUser().getListBookGiven();
        for (BookModel bookModel : bookModelList) {
            ElementBookBean elementBookBean = new ElementBookBean(bookModel.getId());
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
            guiElementBookGivenController.startSetElementGivenBook(elementBookBean);
            viewMyBook.getChildren().add(element);
        }
    }

    public void backButton() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
        Pane pane= fxmlLoader.load();
        guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
        guiHomepageController.setSideWindow(pane);
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
        BookModel bookModel = (BookModel) object1;
        ElementBookBean elementBookBean = new ElementBookBean(element,bookModel.getId());
        GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
        guiElementBookPersonalController.setBookElement(elementBookBean);
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

    public void setCurrentPane(Pane currentPane)
    {
        this.currentPane= currentPane;
    }

    // public void viewSales()
}


