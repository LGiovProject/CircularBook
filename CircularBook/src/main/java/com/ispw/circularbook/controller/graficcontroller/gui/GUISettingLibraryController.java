package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.LibraryController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;

import com.ispw.circularbook.engineering.bean.InfoBookBean;
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
    private Text bookGifted;
    @FXML
    private Text salesInsert;

    @FXML
    private Text welcomeText;
    @FXML
    private ImageView nameImageView;
    @FXML
    private ImageView viaImageView;
    @FXML
    private ImageView cityImageView;
    @FXML
    private ImageView nTelImageView;
    @FXML
    private ChoiceBox<City> cityChoicheBox;

    private LibraryBean libraryBean;
    private LibraryModel libraryModel;

    private Scene previousScene;

    private final Boolean[] rwField= {true,true,true,true};

    final String checkBoxImagePath ="img/ConfirmModify.png";

    final String pencilImagePath="img/Pencil.png";


    final String onStyle="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";

    final String offStyle="fx-border: none; -fx-background-color:none;";


    public void setPreviousScene(Scene scene)
    {
        previousScene=scene;
    }



    public void startSetting()
    {
        InfoBookModel infoBookModel;


        this.libraryModel = Session.getCurrentSession().getLibrary();
        this.libraryBean = this.setLibraryBean();
        this.email.setText(libraryModel.getEmail());
        this.nameLib.setText(libraryModel.getNomeLib());
        this.via.setText(libraryModel.getVia());
        this.city.setText(libraryModel.getCityString());
        this.ntel.setText(String.valueOf(libraryModel.getTelNumber()));
        SearchBookController searchBookController = new SearchBookController();
        InfoBookBean infoBookBean = new InfoBookBean(libraryModel.getEmail());
        infoBookModel = searchBookController.searchBookInfoLibrary(infoBookBean);
        this.bookRegistered.setText(bookStringGenerator(infoBookModel.getRegisterBook()) +" registrati");
        this.bookLended.setText(bookStringGenerator(infoBookModel.getLendedBook())+"  presi in prestito");
        this.bookGifted.setText(bookStringGenerator(infoBookModel.getGiftedBook())+" dati in regalo");
        this.salesInsert.setText(salesStringGenerator(infoBookModel.getSalesInsert()));
        welcomeText.setText(welcomeText.getText()+" "+Session.getCurrentSession().getLibrary().getNomeLib());

        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(libraryModel.getCity());
        cityChoicheBox.setVisible(false);
    }

    public void backToHomepage()  {

        Main.getStage().setScene(this.previousScene);
    }

    private String bookStringGenerator(int i)
    {
        return i==1?"Hai "+i+" libro":"Hai "+i+" libri";
    }

    private String salesStringGenerator(int i){ return i==1?"Hai "+i+" evento inserito":"Hai "+i+" eventi inseriti";}

    public void rewriteField(ActionEvent event) throws IOException {
        Image checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource(checkBoxImagePath)).openStream());
        Image pencilImage = new Image(Objects.requireNonNull(Main.class.getResource(pencilImagePath)).openStream());
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
                    this.libraryBean.setNomeLib(nameLib.getText());
                    nameLib.setText(nameLib.getText());
                    rwField[0]=true;
                }
                break;

            case "two":

                if(rwField[1])
                {
                    via.setEditable(true);
                    via.setStyle(onStyle);
                    viaImageView.setImage(checkBoxImage);

                    rwField[1]=false;
                }else
                {
                    via.setEditable(false);
                    via.setStyle(offStyle);
                    viaImageView.setImage(pencilImage);
                    this.libraryBean.setVia(via.getText());
                    via.setText(via.getText());
                    rwField[1]=true;
                }
                break;

            case "four":
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
                    this.libraryBean.setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
                    city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                    rwField[2]=true;
                }
                break;
            case "three":
                if(rwField[3])
                {
                    ntel.setEditable(true);
                    ntel.setStyle(onStyle);
                    nTelImageView.setImage(checkBoxImage);
                    rwField[3]=false;
                }
                else
                {
                    ntel.setEditable(false);
                    ntel.setStyle(offStyle);
                    nTelImageView.setImage(pencilImage);
                    this.libraryBean.setTelNumber(Integer.parseInt(ntel.getText()));
                    ntel.setText(ntel.getText());
                    rwField[3]=true;

                }
            default:


        }
    }



    public void applyChange()
    {
        LibraryController libraryController = new LibraryController();
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(libraryBean.getEmail(),libraryBean.getCity());
        updateInfoBean.setNameLibrary(libraryBean.getNomeLib());
        updateInfoBean.setVia(libraryBean.getVia());
        updateInfoBean.setNumberPhone(libraryBean.getTelNumber());
        libraryController.updateLibrary(updateInfoBean);
    }

    private LibraryBean setLibraryBean()
    {
        LibraryBean libraryBean = new LibraryBean();
        libraryBean.setNomeLib(libraryModel.getNomeLib());
        libraryBean.setVia(libraryModel.getVia());
        libraryBean.setTelNumber(libraryModel.getTelNumber());
        libraryBean.setCity(libraryModel.getCity());
        return libraryBean;
    }




}
