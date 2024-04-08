package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.Bean.SignInBean;
import com.ispw.circularbook.engineering.Enums.City;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.utils.BoxSuccesfulMessage;
import com.ispw.circularbook.engineering.exception.CityCampRequiredException;
import com.ispw.circularbook.engineering.exception.NoMatchPasswordException;
import com.ispw.circularbook.engineering.exception.PasswordCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUISignInLibraryController {

    @FXML
    private TextField emailTField;
    @FXML
    private PasswordField passwordTField;
    @FXML
    private PasswordField repasswordTField;
    @FXML
    private TextField nomeLTField;
    @FXML
    private TextField ViaTField;
    @FXML
    private ChoiceBox<City> choiceBoxCity;
    @FXML
    private TextField nTelTField;
    @FXML
    Text showPassword;
    @FXML
    Text showRePassword;

    @FXML
    private ImageView padlock;
    @FXML
    private ImageView padlockR;




    public void startSignIn()
    {

            choiceBoxCity.getItems().addAll(City.values());
        choiceBoxCity.getSelectionModel().select(0);
    }

    //Creo una istanza di SignInBean
    //E lancio il metodo SignIn di signInController, dopodiche riporto l'utente sulla schermata login
    public void signIn() throws IOException {

        try {
            SignInBean signInBean = new SignInBean(this.emailTField.getText(), this.passwordTField.getText(), this.repasswordTField.getText(), this.nomeLTField.getText(), this.ViaTField.getText(),this.choiceBoxCity.getSelectionModel().getSelectedItem(), Integer.parseInt(this.nTelTField.getText()));
            SignInController signInController = new SignInController();
            signInController.signInL(signInBean);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);

            Main.getStage().setScene(scene);


        }catch (NoMatchPasswordException | WrongEmailFormattException | PasswordCampRequiredException | CityCampRequiredException e)
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void goToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Main.getStage().setScene(scene);

        BoxExcpetionMessage.PopUpsExcpetionMessage("La registrazione è avvenuta con successo");

    }

    public void showPassword() throws FileNotFoundException {
        showPassword.setVisible(true);
        showPassword.setText(passwordTField.getText());
        showPassword.setOpacity(0.5);
        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padunlock.png");
        Image image = new Image(input);
        padlock.setImage(image);
    }
    public void hiddenPassword() throws FileNotFoundException {
        showPassword.setVisible(false);
        showPassword.setText("");
        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padlock.png");
        Image image = new Image(input);
        padlock.setImage(image);

    }
    public void showRePassword() throws FileNotFoundException {
        showRePassword.setVisible(true);
        showRePassword.setText(repasswordTField.getText());
        showRePassword.setOpacity(0.5);
        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padunlock.png");
        Image image = new Image(input);
        padlockR.setImage(image);
    }
    public void hiddenRePassword() throws FileNotFoundException {
        showRePassword.setVisible(false);
        showRePassword.setText("");
        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padlock.png");
        Image image = new Image(input);
        padlockR.setImage(image);
    }
}