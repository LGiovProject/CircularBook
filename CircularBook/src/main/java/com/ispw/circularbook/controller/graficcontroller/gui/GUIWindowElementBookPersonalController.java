package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxMessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
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

    private Pane currentPane;

    public void setCurrentPane(Pane currentPane)
    {
        this.currentPane= currentPane;
    }

    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void viewBook() throws IOException {
        this.viewInitialization();

        List<BookModel> bookModelList = getSessionOwnBookList();
        for (BookModel bookModel : bookModelList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(element, bookModel.getId());
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            guiElementBookPersonalController.setBookElement(elementBean);
            guiElementBookPersonalController.setPreviuosPane(currentPane);
            guiElementBookPersonalController.setBookElementSubject(bookElementSubject);
            if(previuosScene==null)
                System.out.println("GUIWindowElementBookPersonalController.viewBook() ");
            guiElementBookPersonalController.setCurrentScene(previuosScene);
            viewMyBook.getChildren().add(element);
        }
    }

    public void viewSales() throws IOException{

        this.viewInitialization();
        List<SalesModel> salesModelList = Session.getCurrentSession().getLibrary().getSalesModelList();
        for(SalesModel salesModel : salesModelList){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementSalesPersonal.fxml"));
            Pane element = fxmlLoader.load();
            GUIElementSalesPersonalController guiElementSalesPersonalController = fxmlLoader.getController();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            ElementBean elementBean = new ElementBean(element,salesModel.getId());
//            guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
            guiElementSalesPersonalController.setPreviousScene(previuosScene);
            guiElementSalesPersonalController.setPreviuosPane(currentPane);
            guiElementSalesPersonalController.setElementPersonal(elementBean);
            guiElementSalesPersonalController.setBookElementSubject(bookElementSubject);
            viewMyBook.getChildren().add(element);


        }

    }

    public void viewMyLendedBook() throws IOException {

        this.viewInitialization();
        List<BookModel> listBookModel= Session.getCurrentSession().getUser().getListBookTaked();

        if (listBookModel!=null && !listBookModel.isEmpty()) {
            for (BookModel bookModel : listBookModel) {
                ElementBean elementBean = new ElementBean(bookModel.getId());

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalTaked.fxml"));
                Pane element = fxmlLoader.load();
                GUIElementBookTakedController guiElementBookTakedController= fxmlLoader.getController();

                guiElementBookTakedController.startSetElementTakedBook(elementBean);

                BookElementSubject bookElementSubject = new BookElementSubject();
                bookElementSubject.register(this);
                viewMyBook.getChildren().add(element);
            }
        }else
        {
            BoxMessageSupport.PopUpsExcpetionMessage("Non hai nessun libro preso in prestito");
        }
    }

    public void viewMyGivenBook() throws IOException {
        this.viewInitialization();
        List<BookModel> bookModelList = getSessionBookGiven();
        for (BookModel bookModel : bookModelList) {
            ElementBean elementBean = new ElementBean(bookModel.getId());
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonalGiven.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookGivenController guiElementBookGivenController = fxmlLoader.getController();
            guiElementBookGivenController.startSetElementGivenBook(elementBean);
            viewMyBook.getChildren().add(element);
        }
    }

    public void backButton() throws IOException {
        FXMLLoader fxmlLoader= getSessionFxmlLoader();
        Pane pane= fxmlLoader.load();

        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    @Override
    public void update(Object object1 , Object object2) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookPersonal.fxml"));
        Pane element;
        try {
            element = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BookModel bookModel = (BookModel) object1;
        ElementBean elementBean = new ElementBean(element,bookModel.getId());
        GUIElementBookPersonalController guiElementBookPersonalController = fxmlLoader.getController();
        guiElementBookPersonalController.setBookElement(elementBean);
//        guiHomepageController= Session.getCurrentSession().getGuiHomepageController();
        guiElementBookPersonalController.setCurrentScene(previuosScene);
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

    private List<BookModel> getSessionOwnBookList(){
        if(Session.getCurrentSession().getUser()!=null)
        {
            return Session.getCurrentSession().getUser().getBookOwnList();
        }
        else
        {
            return Session.getCurrentSession().getLibrary().getBookOwnList();
        }
    }

    private List<BookModel> getSessionBookGiven(){

        if(Session.getCurrentSession().getUser()!=null)
        {
            return Session.getCurrentSession().getUser().getListBookGiven();
        }
        else
        {
            return Session.getCurrentSession().getLibrary().getBookGivenList();
        }
    }

    private FXMLLoader getSessionFxmlLoader(){

        if(Session.getCurrentSession().getUser()!=null)
        {
            return new FXMLLoader(Main.class.getResource("ManagementBookUser.fxml"));
        }
        else
        {
            return new FXMLLoader(Main.class.getResource("ManagementBookLibrary.fxml"));
        }
    }
}


