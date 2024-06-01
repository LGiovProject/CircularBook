package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.mysql.cj.util.StringUtils;
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
import java.util.regex.Pattern;


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



    private Scene loginScene;
    private Scene previousScene;

    public void startSignIn(Scene currentScene, Scene previousScene)
    {
        choiceBoxCity.getItems().addAll(City.values());
        choiceBoxCity.getSelectionModel().select(0);
        this.setLoginScene(currentScene);
        this.setPreviousScene(previousScene);
    }



    public void signIn(){

        try{
            checkEmail(emailTField.getText());
            checkPassword(this.passwordTField.getText(),this.repasswordTField.getText());
            checkCity(this.choiceBoxCity.getSelectionModel().getSelectedItem());

            SignInBean signInBean = new SignInBean(this.emailTField.getText(),this.usernameTField.getText(),this.passwordTField.getText(), this.nomeTField.getText(), this.cognomeTField.getText(), this.choiceBoxCity.getSelectionModel().getSelectedItem());

            SignInController signInController = new SignInController();
            signInController.signInU(signInBean);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);

            Main.getStage().setScene(scene);

            BoxExcpetionMessage.PopUpsExcpetionMessage("La registrazione è avvenuta con successo");

        }catch (NoMatchPasswordException | WrongEmailFormattException | PasswordCampRequiredException | CityCampRequiredException e )
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());

        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void goToLogin(){
            Main.getStage().setScene(loginScene);
    }

    public void goBack()
    {
        Main.getStage().setScene(previousScene);
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

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setPreviousScene(Scene previousScene){
            this.previousScene = previousScene;
    }

    private void checkEmail(String email) throws WrongEmailFormattException {
        String checkMail="[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if(!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
    }

    private void checkPassword(String password,String repassword) throws PasswordCampRequiredException, NoMatchPasswordException {
        if(StringUtils.isEmptyOrWhitespaceOnly(password))
            throw new PasswordCampRequiredException();

        if(!password.equals(repassword))
            throw new NoMatchPasswordException();

    }

    private void checkCity(City city) throws CityCampRequiredException {
        if(city==City.Any)
            throw new CityCampRequiredException();
    }
}
