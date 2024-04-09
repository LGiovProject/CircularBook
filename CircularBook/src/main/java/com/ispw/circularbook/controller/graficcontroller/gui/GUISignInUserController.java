package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
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





public class GUISignInUserController {

    @FXML
    private TextField emailTField;
    @FXML
    private PasswordField passwordTField;
    @FXML
    private PasswordField repasswordTField;
    @FXML
    private TextField nomeTField;
    @FXML
    private TextField cognomeTField;
    @FXML
    private TextField usernameTField;
    @FXML
    private ChoiceBox<City> choiceBoxCity;

    @FXML
    private ImageView padlock;
    @FXML
    private ImageView padlockR;

    @FXML
    Text showPassword;
    @FXML
    Text showRePassword;


        public void startSignIn()
        {
            choiceBoxCity.getItems().addAll(City.values());
            choiceBoxCity.getSelectionModel().select(0);
        }



        public void signIn(){
            try{
                    checkEmail(emailTField.getText());
                    SignInBean signInBean = new SignInBean(this.emailTField.getText(),this.usernameTField.getText(),this.passwordTField.getText(), this.repasswordTField.getText(), this.nomeTField.getText(), this.cognomeTField.getText(), this.choiceBoxCity.getSelectionModel().getSelectedItem());

                    SignInController signInController = new SignInController();
                    signInController.signInU(signInBean);

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Main.getStage().setScene(scene);

                    BoxExcpetionMessage.PopUpsExcpetionMessage("La registrazione è avvenuta con successo");

                }catch (EmailUsedException | NoMatchPasswordException | WrongEmailFormattException | PasswordCampRequiredException | CityCampRequiredException e )
                {
                    BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());

                }catch (IOException e)
                {
                    e.printStackTrace();
                }

        }

        public void checkEmail(String email) throws EmailUsedException {

            SignInController signInController = new SignInController();
            signInController.CheckMail(email);
        }



    public void goToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Main.getStage().setScene(scene);
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
