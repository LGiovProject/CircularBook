package com.ispw.circularbook.controller.graficontroller.gui;

//import com.ispw.circularbook.engineering.Bean.LoginBean;
//import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
//import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
//import com.ispw.circularbook.controller.appcontroller.LoginController;
//import com.ispw.circularbook.engineering.Session.ControllerSession;
import javafx.fxml.FXML;
        import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class GUILoginController {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Text showPassword;
    @FXML
    private ImageView padlock;

    public void Login(){}

    public void SignIn(){}

    public void showPassword(){}

    public void hiddenPassword(){}
//
//    //Controller grafico per il login lancia il metodo per il controllo delle credenziali
//    //Fa il Set della sessione se l'account è registrato nel database
//    //O Apre un popup se non c'è stato il match con i dati inseriti nel login e il database
//
//    public void Login() throws IOException {
////        try {
////
////            LoginBean loginBean = new LoginBean(this.textFieldPassword.getText(), this.textFieldEmail.getText());
////            LoginController loginController = new LoginController();
////            loginController.checkLogin(loginBean);
////            if (loginBean.getType() == 1) {
////
////                loginController.userSession(loginBean);
////                LunchHomepage(loginBean);
////
////            } else if (loginBean.getType() == 2) {
////
////                loginController.librarySession(loginBean);
////                LunchHomepage(loginBean);
////
////            } else {
////                BoxExcpetionMessage.PopUpsExcpetionMessage("La mail o la password sono errate");
////            }
////
////        } catch (WrongEmailFormattException e) {
////            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
////        }
//    }
//
//
//    public void SignIn() throws IOException {
//
//        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("PopUpsLogin.fxml"));
//        LunchPopup(fxmlLoader);
//
//
//
//    }
//    //Metodo per il popup in caso di mismatch delle credenziali
//    private void LunchPopup(FXMLLoader fxmlLoader) throws IOException {
////        Popup popup = new Popup();
////
////        Label label = fxmlLoader.load();
////        GUIPopUpsLoginController guiPopUpsLoginController = fxmlLoader.getController();
////        guiPopUpsLoginController.setPopup(popup);
////        popup.getContent().add(label);
////
////        popup.setAutoHide(true);
////
////        popup.show(Main.getStage());
//    }
//    //Metodo che carica l'homepage e lancia il metodo per l'avvio del suo controller
////    public void LunchHomepage(LoginBean loginBean) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Homepage.fxml"));
////
////
////        Parent root = fxmlLoader.load();
////
////        Scene scene = new Scene(root);
////
////        GUIHomepageController guiHomepageController = fxmlLoader.getController();
////
////        ControllerSession.setGuiHomepageController(guiHomepageController);
////        guiHomepageController.homePageStart(loginBean);
////        guiHomepageController.setCurrentScene(scene);
////
////        Main.getStage().setScene(scene);
//}
//
//public void showPassword() throws IOException {
////        showPassword.setVisible(true);
////        showPassword.setText(textFieldPassword.getText());
////        showPassword.setOpacity(0.5);
////        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padunlock.png");
////        Image image = new Image(input);
////        padlock.setImage(image);
//}
//public void hiddenPassword() throws FileNotFoundException {
////        FileInputStream input = new FileInputStream("src/main/resources/com/ispw/circularbook/img/padlock.png");
////        Image image = new Image(input);
////        padlock.setImage(image);
////        showPassword.setVisible(false);
////        showPassword.setText("");
//}


}
