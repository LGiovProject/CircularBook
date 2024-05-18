package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
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
    @FXML
    private Pane panel;

    private Pane previuosPane;

    private int id;

    private BookElementSubject bookElementSubject;


    public void setBookElementSubject(BookElementSubject bookElementSubject) {

        this.bookElementSubject=bookElementSubject;
    }

    private Scene currentScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void setBookElement(ElementBookBean elementBookBean) {
        BookModel bookModel=this.getBookModel(elementBookBean.getId());
        this.id=elementBookBean.getId();
        this.panel=elementBookBean.getPane();

        this.type_of_insert.setText(bookModel.getTypeOfDisponibilityString());
        this.author.setText(bookModel.getAutore());
        this.title.setText(bookModel.getTitolo());
        this.argument.setText(bookModel.getArgomentoString());


    }

    public void moreInfoSearch() throws IOException {
        Session.getCurrentSession().getUser().setLastBookListViewed(Session.getCurrentSession().getUser().getBookOwnList());
        GUIMoreInfoBookController guiMoreInfoBookController;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
        Pane pane = fxmlLoader.load();


        guiMoreInfoBookController = fxmlLoader.getController();
        ElementBookBean elementBookBean = new ElementBookBean(this.id);
        guiMoreInfoBookController.setPreviousPane(this.previuosPane);
        guiMoreInfoBookController.setInfoBook(elementBookBean);

//        GUIHomepageController guiHomepageController = Session.getCurrentSession().getGuiHomepageController();
//        guiHomepageController.setSideWindow(pane);

        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }


    public void modifyBookElement() throws IOException {
        GUIModifyElementBookController guiModifyElementBookController;
        ElementBookBean elementBookBean = new ElementBookBean(this.panel,this.id);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ModifyElementBook.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        guiModifyElementBookController =fxmlLoader.getController();
        Main.getStage().setScene(scene);
        guiModifyElementBookController.setPreviusScene(currentScene);
        guiModifyElementBookController.setBookElementSubject(bookElementSubject);
        guiModifyElementBookController.setElement(elementBookBean);
    }


    public void removeBook(){
        InsertBookController insertBookController= new InsertBookController();
        insertBookController.removeBook(this.id);
        bookElementSubject.notifyObserver(this.panel);
        BoxExcpetionMessage.PopUpsExcpetionMessage("Il libro è stato rimoso correttamente");
    }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : getBookListSession())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

    private List<BookModel> getBookListSession()
    {
        if(Session.getCurrentSession().getUser()!=null)
        {
            return Session.getCurrentSession().getUser().getBookOwnList();
        }
        else
        {
            return Session.getCurrentSession().getLibrary().getBookOwnList();
        }
    }

    public void setPreviuosPane(Pane pane)
    {
        this.previuosPane = pane;
    }



}
