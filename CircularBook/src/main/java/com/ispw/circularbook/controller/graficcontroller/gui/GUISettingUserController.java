package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.BoxMessageSupport;
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

    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField city;

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


    private UserModel userModel;
    private UserBean userBean;

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
        this.userModel = Session.getCurrentSession().getUser();
        this.userBean=this.setUserBean();
        this.email.setText(userModel.getEmail());
        this.email.setEditable(false);
        this.username.setText(userModel.getUsername());
        this.name.setText(userModel.getNome());
        this.surname.setText(userModel.getCognome());
        this.city.setText(userModel.getCityString());
        this.city.setEditable(false);
        SearchBookController searchBookController = new SearchBookController();
        InfoBookBean infoBookBean = new InfoBookBean(userModel.getEmail());
        infoBookModel=searchBookController.searchBookInfoUser(infoBookBean);

        this.bookRegistered.setText(stringGenerator(infoBookModel.getRegisterBook()) +" registrati");
        this.bookLended.setText(stringGenerator(infoBookModel.getLendedBook())+" messi in prestito");
        this.bookGived.setText(stringGenerator(infoBookModel.getGiftedBook())+" messi in regalo");
        this.bookTakeInGift.setText(stringGenerator(infoBookModel.getLendedBookTaked())+" presi in regalo");
        this.bookTakedInLend.setText(stringGenerator(infoBookModel.getGiftedBooktaked())+" presi in prestito");
        String buffer;
        buffer=welcomeText.getText()+" "+Session.getCurrentSession().getUser().getNome();
        welcomeText.setText(buffer);
        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(userModel.getCity());
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


        Image checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource(checkBoxImagePath)).openStream());
        Image pencilImage = new Image(Objects.requireNonNull(Main.class.getResource(pencilImagePath)).openStream());
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "zero":

                    if(this.rwField[0]){
                        this.username.setEditable(true);
                        this.username.setStyle(onStyle);
                        this.usernameImageView.setImage(checkBoxImage);
                        this.rwField[0]=false;
                    }else
                    {
                        this.username.setEditable(false);
                        this.username.setStyle(this.offStyle);
                        this.usernameImageView.setImage(pencilImage);
                        this.userBean.setUsername(this.username.getText());
                        this.username.setText(this.username.getText());
                        this.rwField[0]=true;
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
                        this.name.setEditable(false);
                        this.name.setStyle(this.offStyle);
                        this.nameImageView.setImage(pencilImage);
                        this.userBean.setNome(this.name.getText());
                        this.name.setText(this.name.getText());
                        this.rwField[1]=true;
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
                        userBean.setCognome(surname.getText());
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
                        userBean.setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
                        city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getCity());
                        rwField[3]=true;
                    }
                    break;
            default:


        }
    }

    public void applyChange()
    {
        UserController userController = new UserController();
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(userBean.getEmail(),userBean.getCity());
        updateInfoBean.setNameUser(userBean.getName());
        updateInfoBean.setSurname(userBean.getCognome());
        updateInfoBean.setUsername(userBean.getUsername());
        userController.updateUser(updateInfoBean);
        BoxMessageSupport.PopUpsSuccessMessage("Aggiornamento effettuato con successo");
    }

    private UserBean setUserBean()
    {
        UserBean userBean = new UserBean();
        userBean.setEmail(userModel.getEmail());
        userBean.setNome(userModel.getNome());
        userBean.setCognome(userModel.getCognome());
        userBean.setUsername(userModel.getUsername());
        userBean.setCity(userModel.getCityString());
        return userBean;
    }



}
