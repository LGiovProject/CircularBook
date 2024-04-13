package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.utils.TakeBeanFromList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



import java.io.IOException;
import java.util.List;

public class GUISearchBookController implements Observer {
    @FXML
    TextField textFieldAuthor;
    @FXML
    ChoiceBox<Arguments> argument;
    @FXML
    TextField textFieldTitle;
    @FXML
    VBox showResult;
    @FXML
    ScrollPane scrollPane;


    public void startSetSearch() {
        argument.getItems().addAll(Arguments.values());
        for(Arguments arguments : Arguments.values())
        {
                System.out.println("");
        }
        argument.getSelectionModel().select(0);
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        showResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    public void startToSearchBook() throws IOException {

        showResult.getChildren().clear();
        List<BookBean> listBookBean;
        SearchBookBean searchBookBean = new SearchBookBean(textFieldAuthor.getText(),argument.getSelectionModel().getSelectedItem(),textFieldTitle.getText());
        clearFieldText();
        SearchBookController searchBookController = new SearchBookController();
        listBookBean = searchBookController.searchBook(searchBookBean.getAuthor(),searchBookBean.getArgument(),searchBookBean.getTitle(),TakeBeanFromList.getEmailFromCurrentSession());
        if (!listBookBean.isEmpty()) {
                Session.getCurrentSession().getUser().setBookLastSearch(listBookBean);
                setShowResult(listBookBean);
            } else {
                Text text = new Text("Nessun elemento trovato con i valori che hai inserito");
                showResult.getChildren().add(text);
            }
    }

    public void clearFieldText(){
        argument.getSelectionModel().select(0);
        textFieldAuthor.setText("");
        textFieldTitle.setText("");
    }

    public void setShowResult(List<BookBean> bookBeansList) throws IOException {
        for (BookBean bookBean : bookBeansList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookSearched.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookSearchedController guiElementBookController = fxmlLoader.getController();
            guiElementBookController.setBookElement(bookBean,element);
            guiElementBookController.setBookElementSubject(bookElementSubject);
            showResult.getChildren().add(element);

        }
    }

    @Override
    public void update(Object object1, Object object2) {

        //Da non usare

    }

    @Override
    public void remove(Object object1) {
        int index;
        index=showResult.getChildren().indexOf(object1);
        showResult.getChildren().remove(index);
    }

}


