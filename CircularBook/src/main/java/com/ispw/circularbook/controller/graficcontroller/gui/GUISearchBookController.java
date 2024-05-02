package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.concreteSubject.BookElementSubject;
import com.ispw.circularbook.engineering.utils.TakeBeanFromList;
import com.ispw.circularbook.model.BookModel;
import com.mysql.cj.util.StringUtils;
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

    private Pane currentPane;

    public void setCurrentPane(Pane currentPane){this.currentPane = currentPane;}

    public Pane getCurrentPane(){return currentPane;}

    public void setSearch() {
        argument.getItems().addAll(Arguments.values());
        argument.getSelectionModel().select(0);
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        showResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    public void startToSearchBook() throws IOException {

        showResult.getChildren().clear();
        List<BookModel> listBookModel;
        SearchBookBean searchBookBean = new SearchBookBean(textFieldAuthor.getText(),argument.getSelectionModel().getSelectedItem(),textFieldTitle.getText(),Session.getCurrentSession().getUser().getEmail());
        clearFieldText();
        SearchBookController searchBookController = new SearchBookController();
        listBookModel = searchBookController.searchBook(searchBookBean);
        if (!listBookModel.isEmpty()) {
                Session.getCurrentSession().getUser().setBookLastSearch(listBookModel);
                this.setShowResult(listBookModel);
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

    public void setShowResult(List<BookModel> listBookModel) throws IOException {
        for (BookModel bookModel : listBookModel) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementBookSearched.fxml"));
            Pane element = fxmlLoader.load();
            BookElementSubject bookElementSubject = new BookElementSubject();
            bookElementSubject.register(this);
            GUIElementBookSearchedController guiElementBookSearchedController = fxmlLoader.getController();
            ElementBookBean elementBookBean = new ElementBookBean(element,bookModel.getId());
            guiElementBookSearchedController.setBookElement(elementBookBean);
            guiElementBookSearchedController.setBookElementSubject(bookElementSubject);
            guiElementBookSearchedController.setPreviuosPane(currentPane);
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


