package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.NotifyController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;


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

        private BookModel bookModel;

        private BookElementSubject bookElementSubject;
        private GUIHomepageController guiHomepageController;

        public void setBookElementSubject(BookElementSubject bookElementSubject) {

            this.bookElementSubject=bookElementSubject;
        }


        public void setBookElement(BookBean bookBean,Pane panel) {

            //this.bookModel=bookBean;
            this.type_of_insert.setText(this.bookModel.getTypeOfDisponibilityString());
            this.author.setText(this.bookModel.getAutore());
            this.title.setText(this.bookModel.getTitolo());
            this.argument.setText(this.bookModel.getArgomentoString());
            this.panel=panel;

        }

        public void moreInfoSearch() throws IOException {
          /*  Popup popup = new Popup();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsMoreInfoBook.fxml"));
            Label label = fxmlLoader.load();
            GUIPopUpsMoreInfoBookController guiMoreInfoBookPopUpController = fxmlLoader.getController();
            guiMoreInfoBookPopUpController.moreInfoBook(this.bookBean.getAutore(),this.bookBean.getTitolo(),this.bookBean.getArgomentoString(),this.bookBean.getNpagineString(),this.bookBean.getCommento(),popup);

            popup.getContent().add(label);

            popup.setAutoHide(true);

            popup.show(Main.getStage());
           */
            GUIMoreInfoBookController guiMoreInfoBookController;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
            Pane pane = fxmlLoader.load();
            guiHomepageController = Session.getCurrentSession().getGuiHomepageController();

            guiMoreInfoBookController = fxmlLoader.getController();
            guiMoreInfoBookController.setInfoBook(this.bookModel.getAutore(),this.bookModel.getTitolo(),this.bookModel.getArgomentoString(),this.bookModel.getNpagineString(),this.bookModel.getCommento(),this);
            guiHomepageController.setSideWindow(pane);
        }

        public void getBook(){

//            InsertBookController insertBookController = new InsertBookController();
//            insertBookController.registerLendBook(this.bookModel, Session.getCurrentSession().getUser().getUsername());
//
//            NotifyController notifyController = new NotifyController();
//            notifyController.insertNotify(Session.getCurrentSession().getUser().getEmail(),this.bookModel,getMessage());
//            bookElementSubject.notifyObserver(this.panel);
//            Session.getCurrentSession().getUser().getListBookTaked().add(this.bookModel);
//            BoxExcpetionMessage.PopUpsExcpetionMessage("Il libro è stato preso correttamente");
        }

        private String getMessage()
        {
            return "Il tuo libro "+this.bookModel.getTitolo()+" è stato preso da "+Session.getCurrentSession().getUser().getEmail();
        }

}


