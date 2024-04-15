package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.LibraryController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;

import com.ispw.circularbook.engineering.bean.LibraryBean;

import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.InfoBookModel;
import com.ispw.circularbook.model.LibraryModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;


public class GUISettingLibraryController {

    private LibraryModel libraryModel;

    @FXML
    private Text email;
    @FXML
    private TextField nameLib;
    @FXML
    private TextField via;
    @FXML
    private TextField ntel;
    @FXML
    private Text city;

    @FXML
    private Text bookRegistered;
    @FXML
    private Text bookLended;
    @FXML
    private Text welcomeText;
    @FXML
    private ImageView nameImageView;
    @FXML
    private ImageView surnameImageView;
    @FXML
    private ImageView cityImageView;
    @FXML
    private ImageView nTelmageView;
    @FXML
    private ChoiceBox<City> cityChoicheBox;




    private Scene previousScene;

    private final Boolean[] rwField= {true,true,true,true};






    public void setPreviousScene(Scene scene)
    {
        previousScene=scene;
    }



    public void startSetting()
    {
        InfoBookModel infoBookModel;
        this.libraryModel= Session.getCurrentSession().getLibrary();
        this.email.setText(this.libraryModel.getEmail());
        this.nameLib.setText(this.libraryModel.getNomeLib());
        this.via.setText(this.libraryModel.getVia());
        this.city.setText(this.libraryModel.getCityString());
        this.ntel.setText(String.valueOf(this.libraryModel.getTelNumber()));
        SearchBookController searchBookController = new SearchBookController();
        infoBookModel=searchBookController.searchBookInfoLibrary(this.libraryModel.getEmail());
        libraryModel.setBookInfo(infoBookModel);
        this.bookRegistered.setText(stringGenerator(infoBookModel.getRegisterBook()) +" registrati");
        this.bookLended.setText(stringGenerator(infoBookModel.getLendedBook())+"  presi in prestito");
        welcomeText.setText(welcomeText.getText()+" "+Session.getCurrentSession().getLibrary().getNomeLib());

        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(this.libraryModel.getCity());
        cityChoicheBox.setVisible(false);
    }

    public void backToHomepage()  {

        Main.getStage().setScene(this.previousScene);
    }

    private String stringGenerator(int i)
    {
        return i==1?"Hai "+i+" libro":"Hai "+i+" libri";
    }

    public void modifyInfo(ActionEvent event) throws IOException {
        Image checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource("img/ConfirmModify.png")).openStream());
        Image pencilImage = new Image(Objects.requireNonNull(Main.class.getResource("img/Pencil.png")).openStream());
        String onStyle="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";
        String offStyle="fx-border: none; -fx-background-color:none;";
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "one":

                if (rwField[0]) {
                    nameLib.setEditable(true);
                    nameLib.setStyle(onStyle);
                    nameImageView.setImage(checkBoxImage);
                    rwField[0] = false;

                }else
                {
                    nameLib.setEditable(false);
                    nameLib.setStyle(offStyle);
                    nameImageView.setImage(pencilImage);
                    applyChange("nomeLib",nameLib.getText());
                    Session.getCurrentSession().getLibrary().setNomeLib(nameLib.getText());
                    nameLib.setText(nameLib.getText());
                    rwField[0]=true;
                }
                break;

            case "two":

                if(rwField[1])
                {
                    via.setEditable(true);
                    via.setStyle(onStyle);
                    surnameImageView.setImage(checkBoxImage);

                    rwField[1]=false;
                }else
                {
                    via.setEditable(false);
                    via.setStyle(offStyle);
                    surnameImageView.setImage(pencilImage);
                    applyChange("via",via.getText());
                    Session.getCurrentSession().getLibrary().setVia(via.getText());
                    via.setText(via.getText());
                    rwField[1]=true;
                }
                break;

            case "thre":
                if(rwField[2])
                {
                    cityImageView.setImage(checkBoxImage);
                    cityChoicheBox.setVisible(true);
                    rwField[2]=false;
                }else
                {
                    cityImageView.setImage(pencilImage);
                    cityChoicheBox.setVisible(false);
                    cityChoicheBox.setStyle("-fx-background-color: #F1C9A0; -fx-background-radius: 60;");
                    applyChange("citta",cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                    Session.getCurrentSession().getLibrary().setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
                    city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                    rwField[2]=true;
                }
                break;
            case "four":
                if(rwField[3])
                {
                    ntel.setEditable(true);
                    ntel.setStyle(onStyle);
                    nTelmageView.setImage(checkBoxImage);
                    rwField[3]=false;
                }
                else
                {
                    ntel.setEditable(false);
                    ntel.setStyle(offStyle);
                    nTelmageView.setImage(pencilImage);
                    applyChange("ntel",ntel.getText());
                    Session.getCurrentSession().getLibrary().setTelNumber(Integer.parseInt(ntel.getText()));
                    ntel.setText(ntel.getText());
                    rwField[3]=true;

                }
            default:


        }
    }

    private void applyChange(String camp,String newCamp)
    {
        LibraryController libraryController = new LibraryController();
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(Session.getCurrentSession().getLibrary().getEmail(),camp,newCamp);
        libraryController.updateLibrary(updateInfoBean);
    }





}
