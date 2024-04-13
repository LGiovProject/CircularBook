package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.NotifyController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.session.ControllerSession;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
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

        private BookBean bookBean;

        private BookElementSubject bookElementSubject;
        private GUIHomepageController guiHomepageController;

        public void setBookElementSubject(BookElementSubject bookElementSubject) {

            this.bookElementSubject=bookElementSubject;
        }


        public void setBookElement(BookBean bookBean,Pane panel) {

            this.bookBean=bookBean;
            this.type_of_insert.setText(this.bookBean.getTypeOfDisponibilityString());
            this.author.setText(this.bookBean.getAutore());
            this.title.setText(this.bookBean.getTitolo());
            this.argument.setText(this.bookBean.getArgomentoString());
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
            guiHomepageController = ControllerSession.getGuiHomepageController();

            guiMoreInfoBookController = fxmlLoader.getController();
            guiMoreInfoBookController.setInfoBook(this.bookBean.getAutore(),this.bookBean.getTitolo(),this.bookBean.getArgomentoString(),this.bookBean.getNpagineString(),this.bookBean.getCommento(),this);
            guiHomepageController.setSideWindow(pane);
        }

        public void getBook(){

            InsertBookController insertBookController = new InsertBookController();
            insertBookController.registerLendBook(this.bookBean, Session.getCurrentSession().getUser().getUsername());
            NotifyController notifyController = new NotifyController();
            notifyController.insertNotify(Session.getCurrentSession().getUser().getEmail(),this.bookBean,getMessage(this.bookBean));
            bookElementSubject.notifyObserver(this.panel);
            Session.getCurrentSession().getUser().getBookBean().add(this.bookBean);
            BoxExcpetionMessage.PopUpsExcpetionMessage("Il libro è stato preso correttamente");
        }

        private String getMessage(BookBean bookBean)
        {
            return "Il tuo libro "+bookBean.getTitolo()+" è stato preso da "+Session.getCurrentSession().getUser().getEmail();
        }

}


