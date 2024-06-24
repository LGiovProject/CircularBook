package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;


public class GUIElementBookPersonalController {

    @FXML
    private Text author;
    @FXML
    private Text argument;
    @FXML
    private Text title;
    @FXML
    private Text type_of_insert;

    private Pane element;


    private int id;

    private BookElementSubject bookElementSubject;


    public void setBookElementSubject(BookElementSubject bookElementSubject) {

        this.bookElementSubject=bookElementSubject;
    }

    //La scene serve per modifyBookElement
    private Scene currentScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    //La pane serve per moreInforSearch
    private Pane previuosPane;

    public void setPreviuosPane(Pane pane)
    {
        this.previuosPane = pane;
    }

    public void setBookElement(ElementBean elementBean) {
        BookModel bookModel=this.getBookModel(elementBean.getId());
        this.id= elementBean.getId();
        this.element = elementBean.getPane();
        this.type_of_insert.setText("E' messo in "+bookModel.getTypeOfDisponibilityString());
        this.author.setText(bookModel.getAutore());
        this.title.setText(bookModel.getTitolo());
        this.argument.setText(bookModel.getArgomentoString());


    }

    public void moreInfoSearch() throws IOException {
        setLastBookListViewed();
        GUIMoreInfoBookController guiMoreInfoBookController;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
        Pane pane = fxmlLoader.load();


        guiMoreInfoBookController = fxmlLoader.getController();
        ElementBean elementBean = new ElementBean(this.id);
        guiMoreInfoBookController.setPreviousPane(this.previuosPane);
        guiMoreInfoBookController.setInfoBook(elementBean);


        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }


    public void modifyBookElement() throws IOException {
        GUIModifyElementBookController guiModifyElementBookController;
        ElementBean elementBean = new ElementBean(this.element,this.id);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ModifyElementBook.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        guiModifyElementBookController =fxmlLoader.getController();
        Main.getStage().setScene(scene);
        guiModifyElementBookController.setPreviusScene(currentScene);
        guiModifyElementBookController.setBookElementSubject(bookElementSubject);
        guiModifyElementBookController.setElement(elementBean);
    }


    public void removeBook(){
        InsertBookController insertBookController= new InsertBookController();
        insertBookController.removeBook(this.id);
        bookElementSubject.notifyObserver(this.element);
        MessageSupport.PopUpsSuccessMessage("Il libro è stato rimoso correttamente");
    }

    private BookModel getBookModel(int id) {
        for(BookModel bookModel : getBookListSession())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    private List<BookModel> getBookListSession() {
        return Session.getCurrentSession().getLibrary()==null?Session.getCurrentSession().getUser().getBookOwnList():Session.getCurrentSession().getLibrary().getBookOwnList();
    }

    private void setLastBookListViewed()
    {
        if(Session.getCurrentSession().getUser()!=null)
            Session.getCurrentSession().getUser().setBookLastViewedList(Session.getCurrentSession().getUser().getBookOwnList());
    }



}
