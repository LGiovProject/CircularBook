package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
//import com.ispw.circularbook.controller.appcontroller.NotifyController;
//import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.TakeBookBean;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;


public class GUIElementBookSearchedController {


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
        @FXML
        private Button takeBook;

        private BookModel bookModel;

        private BookElementSubject bookElementSubject;

    private Pane previuosPane;

    public Pane getPreviuosPane() {
        return previuosPane;
    }

    public void setPreviuosPane(Pane currentPane) {
        this.previuosPane = currentPane;
    }

    public void setBookElementSubject(BookElementSubject bookElementSubject) {

            this.bookElementSubject=bookElementSubject;
        }


        public void setBookElement(ElementBean elementBean) {

            if(Session.getCurrentSession().getUser().isGuest())
            {
                takeBook.setVisible(false);
                takeBook.setManaged(false);
            }

            this.bookModel=getBookModel(elementBean.getId());
            this.panel= elementBean.getPane();
            this.type_of_insert.setText("E' messo in "+this.bookModel.getTypeOfDisponibilityString());
            this.author.setText(this.bookModel.getAutore());
            this.title.setText(this.bookModel.getTitolo());
            this.argument.setText(this.bookModel.getArgomentoString());


        }

        public void moreInfoSearch() throws IOException {

            Session.getCurrentSession().getUser().setLastBookListViewed(Session.getCurrentSession().getUser().getBookLastSearch());
            GUIMoreInfoBookController guiMoreInfoBookController;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
            Pane pane = fxmlLoader.load();

            guiMoreInfoBookController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(this.panel,bookModel.getId());
            guiMoreInfoBookController.setInfoBook(elementBean);
            guiMoreInfoBookController.setPreviousPane(this.previuosPane);

            Session.getCurrentSession().getSceneFacade().loadScene(pane);
        }

        public void getBook(){
            InsertBookController insertBookController = new InsertBookController();
            TakeBookBean takeBookBean = new TakeBookBean(bookModel.getId(),bookModel.getEmail(),Session.getCurrentSession().getUser().getEmail(),bookModel.getTypeOfDisponibility(), LocalDate.now());
            insertBookController.registerLendBook(takeBookBean);
            bookElementSubject.notifyObserver(this.panel);
            Session.getCurrentSession().getUser().getListBookTaked().add(this.bookModel);
            MessageSupport.PopUpsSuccessMessage("Il libro è stato preso correttamente");
        }

        private String getMessage()
        {
            return "Il tuo libro "+this.bookModel.getTitolo()+" è stato preso da "+Session.getCurrentSession().getUser().getEmail();
        }

    private BookModel getBookModel(int id)
    {
        for(BookModel bookModel : Session.getCurrentSession().getUser().getBookLastSearch())
        {
            if(bookModel.getId()==id)
                return bookModel;
        }

        return null;
    }

}


