package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.InfoBookModel;
import com.ispw.circularbook.model.UserModel;
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


public class GUISettingUserController {

    private UserModel userModel;

    @FXML
    private Text email;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Text city;

    @FXML
    private Text bookRegistered;
    @FXML
    private Text bookLended;
    @FXML
    private Text bookGived;
    @FXML
    private Text bookTakedInLend;
    @FXML
    private Text bookTakeInGift;
    @FXML
    private Text welcomeText;
    @FXML
    private ImageView usernameImageView;
    @FXML
    private ImageView nameImageView;
    @FXML
    private ImageView surnameImageView;
    @FXML
    private ImageView cityImageView;
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
        this.userModel= Session.getCurrentSession().getUser();
        this.email.setText(this.userModel.getEmail());
        this.username.setText(this.userModel.getUsername());
        this.name.setText(this.userModel.getNome());
        this.surname.setText(this.userModel.getCognome());
        this.city.setText(this.userModel.getCityString());
        SearchBookController searchBookController = new SearchBookController();

        infoBookModel=searchBookController.searchBookInfoUser(this.userModel.getEmail());
        userModel.setBookInfo(infoBookModel);
        this.bookRegistered.setText(stringGenerator(infoBookModel.getRegisterBook()) +" registrati");
        this.bookLended.setText(stringGenerator(infoBookModel.getLendedBook())+" messi in prestito");
        this.bookGived.setText(stringGenerator(infoBookModel.getRegisterBook())+" messi in regalo");
        this.bookTakeInGift.setText(stringGenerator(infoBookModel.getLendedBookTaked())+" presi in regalo");
        this.bookTakedInLend.setText(stringGenerator(infoBookModel.getGiftedBooktaked())+" presi in prestito");
        String buffer;
        buffer=welcomeText.getText()+" "+Session.getCurrentSession().getUser().getNome();
        welcomeText.setText(buffer);
        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(this.userModel.getCity());
        cityChoicheBox.setVisible(false);
    }

    public void backToHomepage()  {

        Main.getStage().setScene(this.previousScene);
    }

    private String stringGenerator(int i)
    {
       return i==1?"Hai "+i+" libro":"Hai "+i+" libri";
    }

    public void rewriteField(ActionEvent event) throws IOException {


        Image checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource("img/ConfirmModify.png")).openStream());
        Image pencilImage = new Image(Objects.requireNonNull(Main.class.getResource("img/Pencil.png")).openStream());
        String onStyle="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";
        String offStyle="fx-border: none; -fx-background-color:none;";
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "zero":

                    if(rwField[0]){
                        username.setEditable(true);
                        username.setStyle(onStyle);
                        usernameImageView.setImage(checkBoxImage);
                        rwField[0]=false;
                    }else
                    {
                        username.setEditable(false);
                        username.setStyle(offStyle);
                        usernameImageView.setImage(pencilImage);
                        applyChange("username",username.getText());
                        Session.getCurrentSession().getUser().setNome(username.getText());
                        username.setText(username.getText());
                        rwField[0]=true;
                    }
                    break;
            case "one":

                    if (rwField[1]) {
                        name.setEditable(true);
                        name.setStyle(onStyle);
                        nameImageView.setImage(checkBoxImage);
                        rwField[1] = false;

                    }else
                    {
                        name.setEditable(false);
                        name.setStyle(offStyle);
                        nameImageView.setImage(pencilImage);
                        applyChange("nome",name.getText());
                        Session.getCurrentSession().getUser().setNome(name.getText());
                        name.setText(name.getText());
                        rwField[1]=true;
                    }
                    break;

            case "two":

                    if(rwField[2])
                    {
                        surname.setEditable(true);
                        surname.setStyle(onStyle);
                        surnameImageView.setImage(checkBoxImage);

                        rwField[2]=false;
                    }else
                    {
                        surname.setEditable(false);
                        surname.setStyle(offStyle);
                        surnameImageView.setImage(pencilImage);
                        applyChange("cognome",surname.getText());
                        Session.getCurrentSession().getUser().setCognome(surname.getText());
                        surname.setText(surname.getText());
                        rwField[2]=true;
                    }
                    break;

            case "thre":
                    if(rwField[3])
                    {
                        cityImageView.setImage(checkBoxImage);
                        cityChoicheBox.setVisible(true);
                        rwField[3]=false;
                    }else
                    {
                        cityImageView.setImage(pencilImage);
                        cityChoicheBox.setVisible(false);
                        cityChoicheBox.setStyle("-fx-background-color: #F1C9A0; -fx-background-radius: 60;");
                        applyChange("citta",cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                        Session.getCurrentSession().getUser().setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
                        city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                        rwField[3]=true;
                    }
                    break;
            default:


        }
    }

    private void applyChange(String camp,String newCamp)
    {
        UserController userController = new UserController();
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(Session.getCurrentSession().getUser().getEmail(),camp,newCamp);
        userController.updateUser(updateInfoBean);

    }



}
