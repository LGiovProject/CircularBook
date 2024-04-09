package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.controller.appcontroller.LoginController;
import com.ispw.circularbook.engineering.session.ControllerSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;


public class GUILoginController {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Text showPassword;
    @FXML
    private ImageView padlock;




    //Controller grafico per il login lancia il metodo per il controllo delle credenziali
    //Fa il Set della sessione se l'account è registrato nel database
    //O Apre un popup se non c'è stato il match con i dati inseriti nel login e il database

    public void Login() throws IOException {
        try {

            LoginBean loginBean = new LoginBean(this.textFieldPassword.getText(), this.textFieldEmail.getText());
            LoginController loginController = new LoginController();
            loginController.checkLogin(loginBean);
            if (loginBean.getType() == 1) {

                loginController.userSession(loginBean);
                this.LunchHomepage(loginBean);

            } else if (loginBean.getType() == 2) {

                loginController.librarySession(loginBean);
                this.LunchHomepage(loginBean);

            } else {
                BoxExcpetionMessage.PopUpsExcpetionMessage("La mail o la password sono errate");
            }

        } catch (WrongEmailFormattException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }


    public void SignIn() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsLogin.fxml"));
        LunchPopup(fxmlLoader);



    }
    //Metodo per il popup in caso di mismatch delle credenziali
    private void LunchPopup(FXMLLoader fxmlLoader) throws IOException {
        Popup popup = new Popup();

        Label label = fxmlLoader.load();
        GUIPopUpsLoginController guiPopUpsLoginController = fxmlLoader.getController();
        guiPopUpsLoginController.setPopup(popup);
        popup.getContent().add(label);

        popup.setAutoHide(true);

        popup.show(Main.getStage());
    }
    //Metodo che carica l'homepage e lancia il metodo per l'avvio del suo controller
    public void LunchHomepage(LoginBean loginBean) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Homepage.fxml"));


        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        GUIHomepageController guiHomepageController = fxmlLoader.getController();

        ControllerSession.setGuiHomepageController(guiHomepageController);
        guiHomepageController.homePageStart(loginBean);
        guiHomepageController.setCurrentScene(scene);

        Main.getStage().setScene(scene);
    }

    public void showPassword() throws IOException {
        showPassword.setVisible(true);
        showPassword.setText(textFieldPassword.getText());
        showPassword.setOpacity(0.5);
       FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/padunlocrk.png");

        Image image = new Image(input);
        padlock.setImage(image);
    }
    public void hiddenPassword() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/padlock.png");
        Image image = new Image(input);
        padlock.setImage(image);
        showPassword.setVisible(false);
        showPassword.setText("");
    }


}
